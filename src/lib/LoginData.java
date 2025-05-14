package lib;

import java.util.ArrayList;

public class LoginData {

    private final ArrayList<Account> userAccounts = new ArrayList<>();
    private final ArrayList<Account> adminAccounts = new ArrayList<>();

    public LoginData() {
        seedAccounts();
    }

    private void seedAccounts() {
        userAccounts.add(new Account("user1", "pass1"));
        userAccounts.add(new Account("user2", "pass2"));
        adminAccounts.add(new Account("admin", "admin123"));
    }

    public ArrayList<Account> getUserAccounts() {
        return userAccounts;
    }

    public ArrayList<Account> getAdminAccounts() {
        return adminAccounts;
    }
}