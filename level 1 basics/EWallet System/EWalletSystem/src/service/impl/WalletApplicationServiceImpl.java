package service.impl;

import model.Account;
import model.WalletSystem;
import service.AccountService;
import service.ApplicationService;

import java.util.Scanner;

public class WalletApplicationServiceImpl implements ApplicationService {
    private final Scanner scanner = new Scanner(System.in);
    private final AccountService accountService = new AccountServiceImpl();

    @Override
    public void start() {
        System.out.println("-> Welcome to " + WalletSystem.name);
        int invalidChoices = 0;
        while (true) {
            System.out.println("\n1.login    2.signup    3.Exit");
            String choice = read("Please choose: ");
            if (choice == null || choice.equals("3")) {
                System.out.println("Have a nice day :)");
                return;
            }
            if (choice.equals("1")) {
                login();
                invalidChoices = 0;
            } else if (choice.equals("2")) {
                signup();
                invalidChoices = 0;
            } else {
                System.out.println("Invalid choice.");
                if (++invalidChoices == 4) {
                    System.out.println("Please contact Admin.");
                    return;
                }
            }
        }
    }

    private void signup() {
        String userName = read("Please enter your username: ");
        String password = read("Please enter your password: ");
        String phoneNumber = read("Please enter your phone number: ");
        String ageText = read("Please enter your age: ");
        if (userName == null || password == null || phoneNumber == null || ageText == null) return;
        try {
            Float age = Float.parseFloat(ageText);
            accountService.createAccount(new Account(userName, password, phoneNumber, age));
            System.out.println("Account created successfully. Please login.");
        } catch (NumberFormatException ex) {
            System.out.println("Age must be a number.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Signup failed: " + ex.getMessage());
        }
    }

    private void login() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            String userName = read("Please enter your username: ");
            String password = read("Please enter your password: ");
            if (userName == null || password == null) return;
            try {
                Account account = accountService.getAccountByUsernameAndPassword(new Account(userName, password));
                System.out.println("Login successful.");
                mainProfile(account);
                return;
            } catch (IllegalArgumentException ex) {
                System.out.println("Login failed: " + ex.getMessage());
                if (attempt < 3) System.out.println((3 - attempt) + " attempt(s) remaining.");
            }
        }
        System.out.println("Too many invalid attempts. Returning to main menu.");
    }

    private void mainProfile(Account account) {
        while (accountService.getAccountByUsername(account.getUserName()) == account && account.isActive()) {
            System.out.println("\n1.deposit   2.withdraw   3.Transfer   4.show balance");
            System.out.println("5.show details   6.Change Password   7.logout");
            System.out.println("8.Transaction history   9.Deactivate account   10.Delete account"
                    + (account.isAdmin() ? "   11.Admin panel" : ""));
            String choice = read("Please choose: ");
            if (choice == null || choice.equals("7")) {
                System.out.println("Goodbye, " + account.getUserName() + ".");
                return;
            }
            try {
                switch (choice) {
                    case "1": {
                        String amount = read("Deposit amount: ");
                        if (amount == null) return;
                        System.out.println("Deposit successful. Updated balance: "
                                + accountService.deposit(account.getUserName(), amount));
                        break;
                    }
                    case "2": {
                        String amount = read("Withdraw amount: ");
                        if (amount == null) return;
                        System.out.println("Withdrawal successful. Updated balance: "
                                + accountService.withdraw(account.getUserName(), amount));
                        break;
                    }
                    case "3": {
                        String destination = read("Destination username: ");
                        String amount = read("Transfer amount: ");
                        if (destination == null || amount == null) return;
                        accountService.transfer(account.getUserName(), destination, amount);
                        System.out.println("Transfer successful. Your balance: " + account.getBalance()
                                + "; " + destination + " balance: "
                                + accountService.getAccountByUsername(destination).getBalance());
                        break;
                    }
                    case "4": System.out.println("Balance: " + account.getBalance()); break;
                    case "5": showDetails(account); break;
                    case "6": changePassword(account); break;
                    case "8": showHistory(account); break;
                    case "9":
                        if (confirmPassword(account)) {
                            accountService.deactivateAccount(account.getUserName(), account.getUserName());
                            System.out.println("Account deactivated. Goodbye.");
                            return;
                        }
                        break;
                    case "10":
                        if (confirmPassword(account)) {
                            accountService.deleteAccount(account.getUserName(), account.getUserName());
                            System.out.println("Account deleted. Goodbye.");
                            return;
                        }
                        break;
                    case "11":
                        if (account.isAdmin()) adminPanel(account);
                        else System.out.println("Invalid choice.");
                        break;
                    default: System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Operation failed: " + ex.getMessage());
            }
        }
    }

    private void showDetails(Account account) {
        Account updated = accountService.getAccountByUsername(account.getUserName());
        if (updated == null) throw new IllegalArgumentException("Account does not exist.");
        System.out.println("Username: " + updated.getUserName());
        System.out.println("Phone: " + updated.getPhoneNumber());
        System.out.println("Age: " + updated.getAge());
        System.out.println("Balance: " + updated.getBalance());
        System.out.println("Password: ********");
    }

    private void changePassword(Account account) {
        String oldPassword = read("Old password: ");
        String newPassword = read("New password: ");
        if (oldPassword == null || newPassword == null) return;
        accountService.changePassword(account.getUserName(), oldPassword, newPassword);
        System.out.println("Password changed successfully.");
    }

    private void showHistory(Account account) {
        if (account.getTransactionHistory().isEmpty()) System.out.println("No transactions yet.");
        else account.getTransactionHistory().stream().forEach(System.out::println);
    }

    private boolean confirmPassword(Account account) {
        String password = read("Confirm password: ");
        if (password == null || !account.getPassword().equals(password)) {
            System.out.println("Incorrect password.");
            return false;
        }
        return true;
    }

    private void adminPanel(Account admin) {
        while (true) {
            System.out.println("\nAdmin: 1.View accounts   2.Deactivate account   3.Delete account   4.Back");
            String choice = read("Please choose: ");
            if (choice == null || choice.equals("4")) return;
            try {
                if (choice.equals("1")) {
                    accountService.getAccounts().stream().forEach(account ->
                        System.out.println(account.getUserName() + " | " + account.getPhoneNumber()
                                + " | age " + account.getAge() + " | balance " + account.getBalance()
                                + " | " + (account.isActive() ? "active" : "inactive")
                                + (account.isAdmin() ? " | admin" : "")));
                } else if (choice.equals("2") || choice.equals("3")) {
                    String target = read("Target username: ");
                    if (target == null) return;
                    if (choice.equals("2")) {
                        accountService.deactivateAccount(admin.getUserName(), target);
                        System.out.println("Account deactivated.");
                    } else {
                        accountService.deleteAccount(admin.getUserName(), target);
                        System.out.println("Account deleted.");
                    }
                } else System.out.println("Invalid choice.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Operation failed: " + ex.getMessage());
            }
        }
    }

    private String read(String prompt) {
        System.out.print(prompt);
        return scanner.hasNextLine() ? scanner.nextLine().trim() : null;
    }
}
