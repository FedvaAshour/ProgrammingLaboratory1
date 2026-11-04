/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg7week;

public class MenuItem {

    private String name;
    private double price;
    private int quantity;

    public MenuItem(String name, double price, int quantity)
            throws InvalidQuantityException {

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive!");
        }

        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be positive!");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive!");
        }
        this.price = price;
    }

    public void setQuantity(int quantity)
            throws InvalidQuantityException {

        if (quantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity!");
        }

        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price
                + " TL | Quantity: " + quantity
                + " | Total: " + getTotalPrice() + " TL";
    }
}

