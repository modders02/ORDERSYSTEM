package user_interface;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final List<MenuItem> cart = new ArrayList<>();

    public MainFrame() {
        setTitle("Chowking Order System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for Logout button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.PINK);
        logoutButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to log out?",
                    "Logout Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (confirm == JOptionPane.YES_OPTION) {
                dispose(); // Close MainFrame
                new logins(); // <-- Replace with your actual login form class
            }
        });
        topPanel.add(logoutButton);
        add(topPanel, BorderLayout.NORTH);

        // Initialize menu items with IDs
        int id = 1;
        menuItems.add(new MainDish(id++, "Chao Fan", 59));
        menuItems.add(new MainDish(id++, "Siomai-rice", 70));
        menuItems.add(new MainDish(id++, "Lauriat", 120));
        menuItems.add(new MainDish(id++, "Sweet and Sour Pork", 110));
        menuItems.add(new MainDish(id++, "Beef Mami", 95));
        menuItems.add(new MainDish(id++, "Wonton Mami", 85));
        menuItems.add(new MainDish(id++, "Lumpiang Shanghai", 60));
        menuItems.add(new MainDish(id++, "Yang Chow Fried Rice", 75));
        menuItems.add(new MainDish(id++, "Pork Chao Fan", 69));
        menuItems.add(new MainDish(id++, "Chicken Chao Fan", 75));
        menuItems.add(new MainDish(id++, "Spicy Chao Fan", 80));
        menuItems.add(new MainDish(id++, "Egg Fried Rice", 50));
        menuItems.add(new MainDish(id++, "Spicy Siomai Rice", 78));
        menuItems.add(new MainDish(id++, "Beef Wanton Noodles", 90));
        menuItems.add(new MainDish(id++, "Tofu Rice Bowl", 65));
        menuItems.add(new MainDish(id++, "Fish Fillet Lauriat", 130));
        menuItems.add(new MainDish(id++, "Pancit Canton", 60));
        menuItems.add(new MainDish(id++, "Pancit Bihon", 65));
        menuItems.add(new MainDish(id++, "Chopsuey", 70));
        menuItems.add(new MainDish(id++, "Chicken Curry", 115));
        menuItems.add(new MainDish(id++, "Spicy Wings", 120));
        menuItems.add(new MainDish(id++, "Steamed Rice", 40));
        menuItems.add(new MainDish(id++, "Beef Broccoli", 130));

        // Beverages
        menuItems.add(new Beverage(id++, "Coke", 25));
        menuItems.add(new Beverage(id++, "Sprite", 25));
        menuItems.add(new Beverage(id++, "Iced-Tea", 30));
        menuItems.add(new Beverage(id++, "Royal", 25));
        menuItems.add(new Beverage(id++, "Mountain Dew", 25));
        menuItems.add(new Beverage(id++, "Bottled Water", 20));
        menuItems.add(new Beverage(id++, "Pineapple Juice", 30));
        menuItems.add(new Beverage(id++, "Mango Shake", 40));
        menuItems.add(new Beverage(id++, "Buko Juice", 35));
        menuItems.add(new Beverage(id++, "Cucumber Lemonade", 38));
        menuItems.add(new Beverage(id++, "Sarsi", 25));
        menuItems.add(new Beverage(id++, "Green Tea", 32));
        menuItems.add(new Beverage(id++, "Red Iced Tea", 30));
        menuItems.add(new Beverage(id++, "Wintermelon Milk Tea", 55));
        menuItems.add(new Beverage(id++, "Taro Milk Tea", 55));
        menuItems.add(new Beverage(id++, "Matcha Milk Tea", 58));
        menuItems.add(new Beverage(id++, "Strawberry Smoothie", 50));
        menuItems.add(new Beverage(id++, "Chocolate Milk", 35));
        menuItems.add(new Beverage(id++, "Hot Coffee", 20));
        menuItems.add(new Beverage(id++, "Hot Tea", 18));
        menuItems.add(new Beverage(id++, "Calamansi Juice", 28));
        menuItems.add(new Beverage(id++, "Iced Coffee", 40));
        menuItems.add(new Beverage(id++, "Cocoa Drink", 38));

        // Desserts
        menuItems.add(new Dessert(id++, "Halo-Halo", 60));
        menuItems.add(new Dessert(id++, "Buchi", 40));
        menuItems.add(new Dessert(id++, "Leche-flan", 50));
        menuItems.add(new Dessert(id++, "Mais con Yelo", 55));
        menuItems.add(new Dessert(id++, "Sago't Gulaman", 45));
        menuItems.add(new Dessert(id++, "Ice Cream Sundae", 35));
        menuItems.add(new Dessert(id++, "Chocolate Cake", 60));
        menuItems.add(new Dessert(id++, "Ube Cake", 65));
        menuItems.add(new Dessert(id++, "Taho", 25));
        menuItems.add(new Dessert(id++, "Macapuno Delight", 50));
        menuItems.add(new Dessert(id++, "Fruit Salad", 55));
        menuItems.add(new Dessert(id++, "Banana Turon", 40));
        menuItems.add(new Dessert(id++, "Mango Float", 60));
        menuItems.add(new Dessert(id++, "Cassava Cake", 50));
        menuItems.add(new Dessert(id++, "Kutsinta", 30));
        menuItems.add(new Dessert(id++, "Puto", 25));
        menuItems.add(new Dessert(id++, "Egg Pie", 45));
        menuItems.add(new Dessert(id++, "Buko Pandan", 55));
        menuItems.add(new Dessert(id++, "Brownies", 40));
        menuItems.add(new Dessert(id++, "Crema de Fruta", 60));
        menuItems.add(new Dessert(id++, "Sticky Rice with Mango", 65));
        menuItems.add(new Dessert(id++, "Banana Split", 70));
        menuItems.add(new Dessert(id++, "Gelatin Cup", 20));

        // Tabbed menu categories
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Main Dish", createCategoryPanel(MainDish.class));
        tabbedPane.addTab("Beverage", createCategoryPanel(Beverage.class));
        tabbedPane.addTab("Desserts", createCategoryPanel(Dessert.class));
        add(tabbedPane, BorderLayout.CENTER);

        // Bottom buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton cartButton = new JButton("Go to Cart");
        cartButton.setBackground(Color.PINK);
        JButton newOrderButton = new JButton("New Order");
        newOrderButton.setBackground(Color.PINK);

        cartButton.addActionListener(e -> showCart());
        newOrderButton.addActionListener(e -> clearCart());

        bottomPanel.add(cartButton);
        bottomPanel.add(newOrderButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createCategoryPanel(Class<? extends MenuItem> type) {
        JPanel panel = new JPanel(new GridLayout(0, 8, 10, 10));

        for (MenuItem item : menuItems) {
            if (type.isInstance(item)) {
                panel.add(new ItemPanel(item));
            }
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        JPanel container = new JPanel(new BorderLayout());
        container.add(scrollPane, BorderLayout.CENTER);

        return container;
    }

    private class ItemPanel extends JPanel {
        private final MenuItem item;

        public ItemPanel(MenuItem item) {
            this.item = item;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createLineBorder(Color.GRAY));
            setPreferredSize(new Dimension(150, 200));

            // Load image
            JLabel itemImageLabel;
            File imageFile = null;
            String baseName = item.getName().toLowerCase().replace(" ", "_");
            String[] extensions = { ".png", ".jpg", ".jpeg", ".gif", ".jfif" };

            for (String ext : extensions) {
                File testFile = new File("resources/" + baseName + ext);
                if (testFile.exists()) {
                    imageFile = testFile;
                    break;
                }
            }

            ImageIcon itemIcon;
            if (imageFile != null) {
                itemIcon = new ImageIcon(imageFile.getAbsolutePath());
                Image scaledImage = itemIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                itemIcon = new ImageIcon(scaledImage);
            } else {
                itemIcon = new ImageIcon();
            }

            add(itemImageLabel = new JLabel(itemIcon));
            itemImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel nameLabel = new JLabel(item.getName());
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(nameLabel);

            JLabel priceLabel = new JLabel("Php " + item.getPrice());
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(priceLabel);

            JButton addButton = new JButton("Add to Cart");
            addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            addButton.setBackground(Color.PINK);
            addButton.addActionListener(e -> addToCart(item));
            add(Box.createVerticalStrut(5));
            add(addButton);
        }

        private void addToCart(MenuItem item) {
            String quantityStr = JOptionPane.showInputDialog(MainFrame.this,
                    "Enter quantity for " + item.getName() + ":", "Quantity", JOptionPane.QUESTION_MESSAGE);

            if (quantityStr == null)
                return;

            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
                if (quantity <= 0)
                    throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(MainFrame.this, "Invalid quantity. Please enter a positive number.");
                return;
            }

            String[] options = { "Dine In", "Take Out" };
            int choice = JOptionPane.showOptionDialog(MainFrame.this, "Choose order type", "Order Type",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == -1)
                return;

            for (int i = 0; i < quantity; i++) {
                cart.add(item);
            }

            JOptionPane.showMessageDialog(MainFrame.this,
                    quantity + " x " + item.getName() + " added to cart (" + options[choice] + ").");
        }
    }

    private void showCart() {
        printReceipt();
    }

    private void printReceipt() {
        StringBuilder receipt = new StringBuilder("Receipt:\n\n");
        double total = 0;

        for (MenuItem item : cart) {
            receipt.append(item.getName()).append(" - Php ").append(item.getPrice()).append("\n");
            total += item.getPrice();
        }

        receipt.append("\nTotal: Php ").append(total);
        JOptionPane.showMessageDialog(this, receipt.toString(), "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearCart() {
        int confirm = JOptionPane.showConfirmDialog(this, "Clear cart?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            cart.clear();
            JOptionPane.showMessageDialog(this, "Cart cleared.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }

    public interface MenuItem {
        int getId();
        String getName();
        double getPrice();
    }

    public static class MainDish implements MenuItem {
        private final int id;
        private final String name;
        private final double price;

        public MainDish(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    public static class Beverage implements MenuItem {
        private final int id;
        private final String name;
        private final double price;

        public Beverage(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    public static class Dessert implements MenuItem {
        private final int id;
        private final String name;
        private final double price;

        public Dessert(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }
}
