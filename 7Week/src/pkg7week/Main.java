
package pkg7week;

public class Main {

    public static void main(String[] args) {

        try {

            // Create two customers
            Customer customer1 = new Customer(
                    "Ali", "05551112233",
                    "Ataturk Street", "Melikgazi", "Kayseri"
            );

            Customer customer2 = new Customer(
                    "Ayse", "05554445566",
                    "Cumhuriyet Street", "Talas", "Kayseri"
            );

            // Create two orders
            Order order1 = new Order(customer1);
            Order order2 = new Order(customer2);

            System.out.println("Order 1: " + order1.getOrderNumber());
            System.out.println("Order 2: " + order2.getOrderNumber());

            // Add items
            order1.addItem(new MenuItem("Burger", 120, 1));
            order1.addItem(new MenuItem("Pizza", 150, 1));

            // Add the same item again
            order1.addItem(new MenuItem("Burger", 120, 2));

            // Update quantity
            order1.updateQuantity("Pizza", 2);

            // Remove item
            order1.removeItem("Burger");

            // Add another item
            order1.addItem(new MenuItem("Pasta", 110, 1));

            // Create coupons
            Coupon coupon1 = new Coupon("SAVE20", 0.20, 100);
            Coupon coupon2 = new Coupon("SAVE50", 0.50, 500);

            // First order: coupon applied
            order1.applyCoupon(coupon1);
            order1.checkout();

            // Second order
            order2.addItem(new MenuItem("Sandwich", 120, 1));

            // Second coupon will not be applied
            order2.applyCoupon(coupon2);
            order2.checkout();

            // Trigger ItemNotFoundException
            try {
                order1.removeItem("Sushi");
            } catch (ItemNotFoundException e) {
                System.out.println("\nItem Exception: " + e.getMessage());
            }

            // Trigger InvalidQuantityException
            try {
                order2.updateQuantity("Sandwich", 0);
            } catch (InvalidQuantityException e) {
                System.out.println("\nQuantity Exception: " + e.getMessage());
            }

            // Trigger MinimumOrderException
            Order order3 = new Order(customer1);

            order3.addItem(new MenuItem("Tea", 20, 1));

            try {
                order3.checkout();
            } catch (MinimumOrderException e) {
                System.out.println("\nMinimum Order Exception: "
                        + e.getMessage());
            }

            // Static statistics
            System.out.println("\n========== STATISTICS ==========");

            System.out.println("Completed Orders: "
                    + Order.getCompletedOrders());

            System.out.println("Total Revenue: "
                    + Order.getTotalRevenue() + " TL");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}