package user_interface;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MenuItemOrderTracker {

    private static final String ORDER_COUNT_FILE = "order_count.txt";
    private final Map<Integer, Integer> orderCounts;

    public MenuItemOrderTracker() {
        this.orderCounts = loadOrderCounts();
    }

    // Load order counts from file
    private Map<Integer, Integer> loadOrderCounts() {
        Map<Integer, Integer> counts = new HashMap<>();
        File file = new File(ORDER_COUNT_FILE);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        int itemId = Integer.parseInt(parts[0]);
                        int count = Integer.parseInt(parts[1]);
                        counts.put(itemId, count);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return counts;
    }

    // Update the order count for an item
    public void updateOrderCount(int itemId) {
        orderCounts.put(itemId, orderCounts.getOrDefault(itemId, 0) + 1);
        saveOrderCounts();
    }

    // Save order counts to file
    private void saveOrderCounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ORDER_COUNT_FILE))) {
            for (Map.Entry<Integer, Integer> entry : orderCounts.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the most ordered item (based on count)
    public int getMostOrderedItem() {
        int mostOrderedId = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : orderCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostOrderedId = entry.getKey();
            }
        }

        return mostOrderedId;
    }

    // Get the order count of a specific item
    public int getOrderCount(int itemId) {
        return orderCounts.getOrDefault(itemId, 0);
    }
}
