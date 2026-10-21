
package week5;

class OvernightPackage extends Package {
    private double additionalFeePerOunce;

    public OvernightPackage(String senderName, String senderAddress,
                            String senderCity, String senderState,
                            String senderZipCode,
                            String recipientName, String recipientAddress,
                            String recipientCity, String recipientState,
                            String recipientZipCode,
                            double weight, double costPerOunce,
                            double additionalFeePerOunce) {

        super(senderName, senderAddress, senderCity, senderState,
              senderZipCode, recipientName, recipientAddress,
              recipientCity, recipientState, recipientZipCode,
              weight, costPerOunce);

        if (additionalFeePerOunce < 0) {
            throw new IllegalArgumentException(
                "Additional fee cannot be negative."
            );
        }

        this.additionalFeePerOunce = additionalFeePerOunce;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost()
               + (getWeight() * additionalFeePerOunce);
    }

    public double getAdditionalFeePerOunce() {
        return additionalFeePerOunce;
    }
    
}