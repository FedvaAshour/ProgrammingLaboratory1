/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg7week;

import java.util.ArrayList;

public class Order {

    private static int nextOrderNumber = 1001;

    public static final double MIN_ORDER = 100.0;
    public static final double DELIVERY_FEE = 20.0;

    private static int completedOrders = 0;
    private static double totalRevenue = 0;

    private int orderNumber;
    private Customer customer;
    private ArrayList<MenuItem> items;
    private Coupon coupon;

    private boolean completed = false;

    public Order(Customer customer) {

        this.customer = customer;
        this.items = new ArrayList<>();

        this.orderNumber = nextOrderNumber++;
    }

    // Add item
    public void addItem(MenuItem item) {

        for (MenuItem current : items) {

            if (current.getName().equalsIgnoreCase(item.getName())) {

                try {
                    current.setQuantity(
                            current.getQuantity() + item.getQuantity()
                    );
                } catch (InvalidQuantityException e) {
                    System.out.println(e.getMessage());
                }

                return;
            }
        }

        items.add(item);
    }

    // Remove item
    public void removeItem(String name)
            throws ItemNotFoundException {

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getName().equalsIgnoreCase(name)) {

                items.remove(i);
                return;
            }
        }

        throw new ItemNotFoundException(
                name + " was not found in the order!");
    }

    // Update quantity
    public void updateQuantity(String name, int quantity)
            throws ItemNotFoundException, InvalidQuantityException {

        for (MenuItem item : items) {

            if (item.getName().equalsIgnoreCase(name)) {

                item.setQuantity(quantity);
                return;
            }
        }

        throw new ItemNotFoundException(
                name + " was not found in the order!");
    }

    // Calculate subtotal
    public double getSubtotal() {

        double subtotal = 0;

        for (MenuItem item : items) {
            subtotal += item.getTotalPrice();
        }

        return subtotal;
    }

    // Return a copy of items
    public ArrayList<MenuItem> getItems() {

        return new ArrayList<>(items);
    }

    // Apply coupon
    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public static int getCompletedOrders() {
        return completedOrders;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    // Checkout
    public double checkout() throws MinimumOrderException {

        if (completed) {
            throw new IllegalStateException(
                    "This order has already been completed!");
        }

        double subtotal = getSubtotal();

        if (subtotal < MIN_ORDER) {
            throw new MinimumOrderException(
                    "Minimum order amount is 100 TL!");
        }

        double discount = 0;

        if (coupon != null &&
                subtotal >= coupon.getMinSubtotal()) {

            discount = subtotal * coupon.getDiscountRate();
        }

        double total = subtotal - discount + DELIVERY_FEE;

        // Print receipt
        System.out.println("\n========== RECEIPT ==========");

        System.out.println("Order Number: " + orderNumber);

        System.out.println("Customer: " + customer.getName());

        System.out.println("Address: " + customer.getAddress());

        System.out.println("\nItems:");

        for (MenuItem item : items) {
            System.out.println(item);
        }

        System.out.println("-----------------------------");

        System.out.println("Subtotal: " + subtotal + " TL");

        System.out.println("Coupon Discount: " + discount + " TL");

        System.out.println("Delivery Fee: " + DELIVERY_FEE + " TL");

        System.out.println("Total: " + total + " TL");

        System.out.println("=============================");

        completed = true;

        completedOrders++;
        totalRevenue += total;

        return total;
    }
}