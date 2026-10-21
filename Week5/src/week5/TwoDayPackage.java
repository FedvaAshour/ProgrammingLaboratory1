
package week5;

class TwoDayPackage extends Package {
    private double flatFee;

    public TwoDayPackage(String senderName, String senderAddress,
                         String senderCity, String senderState,
                         String senderZipCode,
                         String recipientName, String recipientAddress,
                         String recipientCity, String recipientState,
                         String recipientZipCode,
                         double weight, double costPerOunce,
                         double flatFee) {

        super(senderName, senderAddress, senderCity, senderState,
              senderZipCode, recipientName, recipientAddress,
              recipientCity, recipientState, recipientZipCode,
              weight, costPerOunce);

        if (flatFee < 0) {
            throw new IllegalArgumentException(
                "Flat fee cannot be negative."
            );
        }

        this.flatFee = flatFee;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + flatFee;
    }

    public double getFlatFee() {
        return flatFee;
    }
    
}


