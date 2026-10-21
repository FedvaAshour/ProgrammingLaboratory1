
package week5;

public class Package {
    private String senderName;
    private String senderAddress;
    private String senderCity;
    private String senderState;
    private String senderZipCode;

    private String recipientName;
    private String recipientAddress;
    private String recipientCity;
    private String recipientState;
    private String recipientZipCode;

    private double weight;
    private double costPerOunce;

    public Package(String senderName, String senderAddress,
                   String senderCity, String senderState,
                   String senderZipCode,
                   String recipientName, String recipientAddress,
                   String recipientCity, String recipientState,
                   String recipientZipCode,
                   double weight, double costPerOunce) {

        if (weight <= 0 || costPerOunce <= 0) {
            throw new IllegalArgumentException(
                "Weight and cost per ounce must be positive."
            );
        }

        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderCity = senderCity;
        this.senderState = senderState;
        this.senderZipCode = senderZipCode;

        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.recipientCity = recipientCity;
        this.recipientState = recipientState;
        this.recipientZipCode = recipientZipCode;

        this.weight = weight;
        this.costPerOunce = costPerOunce;
    }

    public double calculateCost() {
        return weight * costPerOunce;
    }

    public void displayInfo() {
        System.out.println("Sender: " + senderName);
        System.out.println("Recipient: " + recipientName);
        System.out.println("Weight: " + weight + " ounces");
    }

    public double getWeight() {
        return weight;
        
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public String getSenderState() {
        return senderState;
    }

    public String getSenderZipCode() {
        return senderZipCode;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public String getRecipientCity() {
        return recipientCity;
    }

    public String getRecipientState() {
        return recipientState;
    }

    public String getRecipientZipCode() {
        return recipientZipCode;
    }

    public double getCostPerOunce() {
        return costPerOunce;
    }

}
