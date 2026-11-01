
public class GroceryListTester {

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
