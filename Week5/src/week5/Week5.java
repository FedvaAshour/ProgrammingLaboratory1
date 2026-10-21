
package week5;


public class Week5 {

   
  
public static void main(String[] args) {

    Package standard = new Package(
        "Ahmet Yilmaz", "Talas Bulvari No:15",
        "Kayseri", "TR", "38039",
        "Mehmet Demir", "Ataturk Cad. No:42",
        "Ankara", "TR", "06100",
        10, 2.5
    );

    TwoDayPackage twoDay = new TwoDayPackage(
        "Ayse Kaya", "Bagdat Cad. No:8",
        "Istanbul", "TR", "34710",
        "Fatma Sahin", "Cumhuriyet Mah. No:12",
        "Izmir", "TR", "35220",
        10, 2.5, 5.0
    );

    OvernightPackage overnight = new OvernightPackage(
        "Can Celik", "Universite Cad. No:1",
        "Kayseri", "TR", "38030",
        "Ali Ozturk", "Inonu Bulvari No:99",
        "Bursa", "TR", "16050",
        10, 2.5, 1.25
    );

System.out.println("[Standard Package]");
System.out.println("Sender: " + standard.getSenderName()
        + ", " + standard.getSenderAddress()
        + ", " + standard.getSenderCity()
        + ", " + standard.getSenderState()
        + " " + standard.getSenderZipCode());

System.out.println("Recipient: " + standard.getRecipientName()
        + ", " + standard.getRecipientAddress()
        + ", " + standard.getRecipientCity()
        + ", " + standard.getRecipientState()
        + " " + standard.getRecipientZipCode());

System.out.println("Weight: " + standard.getWeight()
        + " oz | Cost per ounce: $" + standard.getCostPerOunce());

System.out.println("Total Shipping Cost: $"
        + String.format("%.2f", standard.calculateCost()));

System.out.println();
 System.out.println("[Two-Day Package]");

    System.out.println("Sender: " + twoDay.getSenderName()
            + ", " + twoDay.getSenderAddress()
            + ", " + twoDay.getSenderCity()
            + ", " + twoDay.getSenderState()
            + " " + twoDay.getSenderZipCode());

    System.out.println("Recipient: " + twoDay.getRecipientName()
            + ", " + twoDay.getRecipientAddress()
            + ", " + twoDay.getRecipientCity()
            + ", " + twoDay.getRecipientState()
            + " " + twoDay.getRecipientZipCode());

    System.out.println("Weight: " + twoDay.getWeight()
            + " oz | Cost per ounce: $"
            + twoDay.getCostPerOunce());

    System.out.println("Flat Fee: $" + twoDay.getFlatFee());

    System.out.println("Total Shipping Cost: $"
            + String.format("%.2f", twoDay.calculateCost()));

    System.out.println();

    // Overnight Package
    System.out.println("[Overnight Package]");

    System.out.println("Sender: " + overnight.getSenderName()
            + ", " + overnight.getSenderAddress()
            + ", " + overnight.getSenderCity()
            + ", " + overnight.getSenderState()
            + " " + overnight.getSenderZipCode());

    System.out.println("Recipient: " + overnight.getRecipientName()
            + ", " + overnight.getRecipientAddress()
            + ", " + overnight.getRecipientCity()
            + ", " + overnight.getRecipientState()
            + " " + overnight.getRecipientZipCode());

    System.out.println("Weight: " + overnight.getWeight()
            + " oz | Cost per ounce: $"
            + overnight.getCostPerOunce());

    System.out.println("Additional Fee Per Ounce: $"
            + overnight.getAdditionalFeePerOunce());

    System.out.println("Total Shipping Cost: $"
            + String.format("%.2f", overnight.calculateCost()));
  

}

}
