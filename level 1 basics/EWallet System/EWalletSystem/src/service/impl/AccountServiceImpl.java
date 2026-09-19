package service.impl;

import model.Account;
import model.WalletSystem;
import service.AccountService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final WalletSystem walletSystem = new WalletSystem();

    @Override
    public Account createAccount(Account account) {
        if (account == null) throw new IllegalArgumentException("Account details are required.");
        validateUsername(account.getUserName());
        validatePassword(account.getPassword());
        if (account.getAge() == null || !Float.isFinite(account.getAge()) || account.getAge() < 18)
            throw new IllegalArgumentException("Age must be at least 18.");
        if (account.getPhoneNumber() == null || !account.getPhoneNumber().matches("01[0125][0-9]{8}"))
            throw new IllegalArgumentException("Phone must be an 11-digit Egyptian mobile number.");
        if (getAccountByUsername(account.getUserName()) != null)
            throw new IllegalArgumentException("Username already exists.");
        boolean phoneExists = walletSystem.getAccounts().stream()
                .anyMatch(existing -> existing.getPhoneNumber().equals(account.getPhoneNumber()));
        if (phoneExists) throw new IllegalArgumentException("Phone number already exists.");
        account.setAdmin(false);
        account.setActive(true);
        account.setBalance(0.0);
        walletSystem.getAccounts().add(account);
        record(account, "Signed up");
        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        if (account == null || isBlank(account.getUserName()) || isBlank(account.getPassword()))
            throw new IllegalArgumentException("Username and password are required.");
        Account existing = requireActive(account.getUserName());
        if (!existing.getPassword().equals(account.getPassword()))
            throw new IllegalArgumentException("Incorrect password.");
        record(existing, "Logged in");
        return existing;
    }

    @Override
    public Account getAccountByUsername(String userName) {
        return walletSystem.getAccounts().stream()
                .filter(account -> account.getUserName().equals(userName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> getAccounts() {
        return Collections.unmodifiableList(walletSystem.getAccounts());
    }

    @Override
    public double deposit(String userName, String amount) {
        Account account = requireActive(userName);
        BigDecimal value = parseAmount(amount);
        account.setBalance(safeBalance(balance(account).add(value)));
        record(account, "Deposited " + value.toPlainString());
        return account.getBalance();
    }

    @Override
    public double withdraw(String userName, String amount) {
        Account account = requireActive(userName);
        BigDecimal value = parseAmount(amount);
        ensureSufficientBalance(account, value);
        account.setBalance(safeBalance(balance(account).subtract(value)));
        record(account, "Withdrew " + value.toPlainString());
        return account.getBalance();
    }

    @Override
    public void transfer(String sourceUserName, String destinationUserName, String amount) {
        Account source = requireActive(sourceUserName);
        if (isBlank(destinationUserName)) throw new IllegalArgumentException("Destination username is required.");
        Account destination = requireActive(destinationUserName);
        if (source == destination) throw new IllegalArgumentException("Cannot transfer to yourself.");
        BigDecimal value = parseAmount(amount);
        ensureSufficientBalance(source, value);
        double sourceBalance = safeBalance(balance(source).subtract(value));
        double destinationBalance = safeBalance(balance(destination).add(value));
        source.setBalance(sourceBalance);
        destination.setBalance(destinationBalance);
        record(source, "Transferred " + value.toPlainString() + " to " + destinationUserName);
        record(destination, "Received " + value.toPlainString() + " from " + sourceUserName);
    }

    @Override
    public void changePassword(String userName, String oldPassword, String newPassword) {
        Account account = requireActive(userName);
        if (oldPassword == null || !account.getPassword().equals(oldPassword))
            throw new IllegalArgumentException("Old password is incorrect.");
        validatePassword(newPassword);
        if (oldPassword.equals(newPassword))
            throw new IllegalArgumentException("New password must be different from old password.");
        account.setPassword(newPassword);
        record(account, "Changed password");
    }

    @Override
    public void deactivateAccount(String actorUserName, String targetUserName) {
        Account actor = requireActive(actorUserName);
        Account target = requireActive(targetUserName);
        authorize(actor, target);
        target.setActive(false);
        record(target, "Account deactivated by " + actorUserName);
    }

    @Override
    public void deleteAccount(String actorUserName, String targetUserName) {
        Account actor = requireActive(actorUserName);
        Account target = requireAccount(targetUserName);
        authorize(actor, target);
        walletSystem.getAccounts().remove(target);
    }

    private void authorize(Account actor, Account target) {
        if (!actor.isAdmin() && actor != target) throw new IllegalArgumentException("Permission denied.");
        if (target.isAdmin()) throw new IllegalArgumentException("Admin account cannot be deleted or deactivated.");
    }

    private Account requireAccount(String userName) {
        Account account = getAccountByUsername(userName);
        if (account == null) throw new IllegalArgumentException("Account does not exist.");
        return account;
    }

    private Account requireActive(String userName) {
        Account account = requireAccount(userName);
        if (!account.isActive()) throw new IllegalArgumentException("Account is inactive.");
        return account;
    }

    private static BigDecimal balance(Account account) {
        return BigDecimal.valueOf(account.getBalance());
    }

    private static double safeBalance(BigDecimal value) {
        double converted = value.doubleValue();
        if (!Double.isFinite(converted) || BigDecimal.valueOf(converted).compareTo(value) != 0)
            throw new IllegalArgumentException("Amount exceeds supported balance precision.");
        return converted;
    }

    private static void ensureSufficientBalance(Account account, BigDecimal amount) {
        if (balance(account).compareTo(amount) < 0)
            throw new IllegalArgumentException("Insufficient balance.");
    }

    private static BigDecimal parseAmount(String text) {
        try {
            if (isBlank(text)) throw new NumberFormatException();
            BigDecimal amount = new BigDecimal(text);
            if (amount.scale() > 2) throw new IllegalArgumentException("Amount must have at most two decimal places.");
            if (amount.signum() <= 0) throw new IllegalArgumentException("Amount must be greater than zero.");
            return amount;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Amount must be a valid number.");
        }
    }

    private static void validateUsername(String userName) {
        if (userName == null || userName.length() < 3 || userName.length() > 20
                || !userName.matches("[A-Z][A-Za-z0-9_]*(?: [A-Za-z0-9_]+)*"))
            throw new IllegalArgumentException("Username must be 3-20 characters, start with an uppercase letter, and may contain spaces between words.");
    }

    private static void validatePassword(String password) {
        if (password == null || password.length() < 8 || password.length() > 64
                || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")
                || !password.matches(".*[0-9].*"))
            throw new IllegalArgumentException("Password must be 8-64 characters with uppercase, lowercase and a number.");
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static void record(Account account, String entry) {
        account.getTransactionHistory().add(entry);
    }
}
