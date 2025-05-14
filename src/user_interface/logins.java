package user_interface;

import javax.swing.*;

import lib.Account;

public class logins extends Login_Form {

    @Override
    protected void onLogin(String username, String password) {
        boolean isValid = false;

        for (Account account : userAccounts) {
            if (account.getUsername().equals(username) && account.checkPassword(password)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            for (Account account : adminAccounts) {
                if (account.getUsername().equals(username) && account.checkPassword(password)) {
                    isValid = true;
                    break;
                }
            }
        }

        if (isValid) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            this.dispose(); 
            new MainFrame().setVisible(true); 
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    protected void onRegister() {
        JOptionPane.showMessageDialog(this, "Go to registration.");
    }

    @Override
    protected void onAdminLogin() {
        JOptionPane.showMessageDialog(this, "Admin login clicked.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(logins::new);
    }
}