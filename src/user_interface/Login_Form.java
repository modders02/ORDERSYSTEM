package user_interface;

import lib.Account;
import lib.LoginData;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Login_Form extends JFrame {

    protected JTextField usernameField;
    protected JPasswordField passwordField;
    protected JButton btnLogin, btnRegister, btnAdmin;

    protected ArrayList<Account> userAccounts;
    protected ArrayList<Account> adminAccounts;

    public Login_Form() {
        setTitle("Chowking Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(240, 230, 140)); // Khaki
        setLayout(null); // Absolute positioning

        LoginData loginData = new LoginData(); // Fetch pre-seeded accounts
        userAccounts = loginData.getUserAccounts();
        adminAccounts = loginData.getAdminAccounts();

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        Font headerFont = new Font("Segoe UI", Font.BOLD, 28);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);

        // Header
        JLabel lblHeader = new JLabel("Chowking Login Portal", SwingConstants.CENTER);
        lblHeader.setFont(headerFont);
        lblHeader.setBounds(0, 60, screenWidth, 40);
        add(lblHeader);

        // Center login panel
        JPanel loginPanel = new JPanel(null);
        loginPanel.setBounds((screenWidth - 400) / 2, (screenHeight - 300) / 2, 400, 250);
        loginPanel.setBackground(new Color(255, 255, 255, 150)); // Optional: translucent white
        add(loginPanel);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(labelFont);
        lblUsername.setBounds(30, 30, 100, 30);
        loginPanel.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(140, 30, 200, 30);
        loginPanel.add(usernameField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(labelFont);
        lblPassword.setBounds(30, 80, 100, 30);
        loginPanel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 80, 200, 30);
        loginPanel.add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(140, 130, 200, 35);
        loginPanel.add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setForeground(Color.BLUE);
        btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegister.setBounds(250, 170, 80, 20);
        loginPanel.add(btnRegister);

        // Admin login button (bottom-right)
        btnAdmin = new JButton("Admin Login");
        btnAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnAdmin.setBounds(screenWidth - 160, screenHeight - 80, 130, 30);
        add(btnAdmin);

        // Event listeners
        btnLogin.addActionListener(e -> onLogin(usernameField.getText(), new String(passwordField.getPassword())));
        btnRegister.addActionListener(e -> onRegister());
        btnAdmin.addActionListener(e -> onAdminLogin());
    }

    // Abstract methods for implementation in subclass
 // Inside Login_Form.java
    protected void onLogin(String username, String password) {
        boolean isValid = false;

        // Check user accounts first
        for (Account account : userAccounts) {
            if (account.getUsername().equals(username) && account.checkPassword(password)) {
                isValid = true;
                break;
            }
        }

        // Check admin accounts if not found in user accounts
        if (!isValid) {
            for (Account account : adminAccounts) {
                if (account.getUsername().equals(username) && account.checkPassword(password)) {
                    isValid = true;
                    break;
                }
            }
        }

        if (isValid) {
            // Successful login
            JOptionPane.showMessageDialog(this, "Login successful!");
            this.dispose(); // Close the login window
            new MainFrame().setVisible(true); // Open the main order window
        } else {
            // Invalid login
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    protected abstract void onRegister();
    protected abstract void onAdminLogin();
}