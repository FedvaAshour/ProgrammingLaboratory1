/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg7week;


public class Coupon {

    private String code;
    private double discountRate;
    private double minSubtotal;

    public Coupon(String code, double discountRate, double minSubtotal) {

        if (discountRate < 0 || discountRate > 0.50) {
            throw new IllegalArgumentException(
                    "Discount must be between 0 and 50%!");
        }

        if (minSubtotal < 0) {
            throw new IllegalArgumentException(
                    "Minimum subtotal cannot be negative!");
        }

        this.code = code;
        this.discountRate = discountRate;
        this.minSubtotal = minSubtotal;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getMinSubtotal() {
        return minSubtotal;
    }
}