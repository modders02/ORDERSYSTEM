package user_interface;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptSaver {

    private static final String RECEIPT_COUNTER_FILE = "receipt_counter.txt";
    private static MenuItemOrderTracker orderTracker = new MenuItemOrderTracker();

    public static void saveReceiptToFile(List<MainFrame.MenuItem> cartItems, double total, List<MainFrame.MenuItem> allMenuItems) {
        try {
            int receiptId = getNextReceiptId();
            String receiptIdFormatted = String.format("%04d", receiptId);

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "receipt_" + timestamp + ".txt";

            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println("Receipt: " + receiptIdFormatted);
            writer.println();

            for (MainFrame.MenuItem item : cartItems) {
                writer.println(item.getName() + " - Php " + item.getPrice());
                // Update the order count for each item
                orderTracker.updateOrderCount(item.getId());
            }

            writer.println();
            writer.println("Total: Php " + total);
            writer.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            writer.close();

            System.out.println("Receipt saved as " + fileName);
            System.out.println("Most ordered item: " + getMostOrderedItemName(allMenuItems));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getNextReceiptId() {
        int currentId = 0;

        File file = new File(RECEIPT_COUNTER_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                currentId = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }

        int nextId = currentId + 1;
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println(nextId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nextId;
    }

    // Modified to accept allMenuItems as argument
    private static String getMostOrderedItemName(List<MainFrame.MenuItem> allMenuItems) {
        int mostOrderedItemId = orderTracker.getMostOrderedItem();
        if (mostOrderedItemId == -1) {
            return "No orders yet.";
        }

        for (MainFrame.MenuItem item : allMenuItems) {
            if (item.getId() == mostOrderedItemId) {
                return item.getName();
            }
        }

        return "Unknown item";
    }
}
