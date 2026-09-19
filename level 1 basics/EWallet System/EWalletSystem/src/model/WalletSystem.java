package model;

import java.util.ArrayList;
import java.util.List;

public class WalletSystem {
    public final static String name = "EraaSoft Wallet";
    private List<Account> accounts = new ArrayList<>();

    public WalletSystem() {
        Account admin = new Account("IAM", "IAM123", "01000000000", 18.0f);
        admin.setAdmin(true);
        accounts.add(admin);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
