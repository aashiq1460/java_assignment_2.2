
import java.util.HashMap;

public class GroceryListManager {

    private HashMap<String, Double> groceryList = new HashMap<>();
    private HashMap<String, String> categories = new HashMap<>();
    private HashMap<String, Integer> quantities = new HashMap<>();

    public void addItem(String item, double cost) {
        addItem(item, cost, "Other", 1);
    }

    public void addItem(String item, double cost, String category) {
        addItem(item, cost, category, 1);
    }

    public void addItem(String item, double cost, String category, int quantity) {
        if (cost >= 0 && quantity >= 0) {
            groceryList.put(item, cost);
            categories.put(item, category);
            quantities.put(item, quantity);
        }
    }

    public void removeItem(String item) {
        groceryList.remove(item);
        categories.remove(item);
        quantities.remove(item);
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public void displayList() {
        System.out.println("Grocery List:");

        for (String item : groceryList.keySet()) {
            System.out.println(item + " - " + groceryList.get(item) + " euros");
        }
    }

    public double calculateTotalCost() {
        double total = 0;

        for (String item : groceryList.keySet()) {
            double cost = groceryList.get(item);
            int quantity = quantities.get(item);

            total = total + cost * quantity;
        }

        return total;
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);

        for (String item : categories.keySet()) {
            if (categories.get(item).equals(category)) {
                System.out.println(item);
            }
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        if (quantities.containsKey(item) && newQuantity >= 0) {
            quantities.put(item, newQuantity);
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");

        for (String item : quantities.keySet()) {
            int quantity = quantities.get(item);

            if (quantity > 0) {
                System.out.println(item + " - Quantity: " + quantity);
            }
        }
    }

    public static void main(String[] args) {

        GroceryListManager grocery = new GroceryListManager();

        grocery.addItem("Apples", 3.00, "Fruits", 3);
        grocery.addItem("Bananas", 2.00, "Fruits", 2);
        grocery.addItem("Milk", 2.50, "Dairy", 1);
        grocery.addItem("Bread", 2.00, "Bakery", 0);

        grocery.displayList();

        System.out.println();
        System.out.println("Total cost: " + grocery.calculateTotalCost() + " euros");

        System.out.println();
        grocery.displayByCategory("Fruits");

        System.out.println();
        grocery.displayByCategory("Dairy");

        System.out.println();
        grocery.displayAvailableItems();

        System.out.println();
        System.out.println("Updating Milk quantity to 3...");
        grocery.updateQuantity("Milk", 3);

        System.out.println();
        grocery.displayAvailableItems();

        System.out.println();
        System.out.println("New total cost: " + grocery.calculateTotalCost() + " euros");

        System.out.println();
        System.out.println("Is Bread in the list? " + grocery.checkItem("Bread"));

        System.out.println();
        System.out.println("Removing Bread...");
        grocery.removeItem("Bread");

        System.out.println("Is Bread in the list? " + grocery.checkItem("Bread"));
    }
}
