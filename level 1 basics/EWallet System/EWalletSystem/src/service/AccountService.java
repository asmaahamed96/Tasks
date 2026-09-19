package service;

import model.Account;
import java.util.List;

public interface AccountService {
    Account createAccount(Account account);

    Account getAccountByUsernameAndPassword(Account account);

    Account getAccountByUsername(String userName);

    List<Account> getAccounts();

    double deposit(String userName, String amount);

    double withdraw(String userName, String amount);

    void transfer(String sourceUserName, String destinationUserName, String amount);

    void changePassword(String userName, String oldPassword, String newPassword);

    void deactivateAccount(String actorUserName, String targetUserName);

    void deleteAccount(String actorUserName, String targetUserName);
}
