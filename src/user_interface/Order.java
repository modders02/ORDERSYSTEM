package user_interface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class OrderQueueManager {
    private static OrderQueueManager instance;
    private final Queue<Order> orderQueue = new LinkedList<>();
    private final List<OrderObserver> observers = new ArrayList<>();

    private OrderQueueManager() {}

    public static OrderQueueManager getInstance() {
        if (instance == null) {
            instance = new OrderQueueManager();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orderQueue.offer(order);
        notifyObservers(order);
    }

    public Order getNextOrder() {
        return orderQueue.poll();
    }

    public void registerObserver(OrderObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Order order) {
        for (OrderObserver observer : observers) {
            observer.onOrderReceived(order);
        }
    }
}

// Observer Pattern
interface OrderObserver {
    void onOrderReceived(Order order);
}

class KitchenStaff implements OrderObserver {
    private final String name;

    public KitchenStaff(String name) {
        this.name = name;
    }

    @Override
    public void onOrderReceived(Order order) {
        System.out.println(name + " received order: " + order);
    }
}

// Factory Pattern
abstract class MenuItem {
    protected String name;
    protected double price;

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - Php " + price;
    }
}

class MainDish extends MenuItem {
    public MainDish(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Beverage extends MenuItem {
    public Beverage(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Dessert extends MenuItem {
    public Dessert(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    private final List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}

class MenuItemFactory {
    public static MenuItem createMenuItem(String type, String name, double price) {
        return switch (type.toLowerCase()) {
            case "main" -> new MainDish(name, price);
            case "beverage" -> new Beverage(name, price);
            case "dessert" -> new Dessert(name, price);
            default -> throw new IllegalArgumentException("Unknown menu item type: " + type);
        };
    }
}