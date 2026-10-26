
package week6;

class PremiumRide extends Ride {
    private double comfortFee;
    private double surgeMultiplier;

    public PremiumRide(String passengerName, String pickup,
                       String destination, double distanceKm,
                       int durationMin, double pricePerKm,
                       double comfortFee, double surgeMultiplier) {

        super(passengerName, pickup, destination,
                distanceKm, durationMin, pricePerKm);

        if (comfortFee < 0) {
            System.out.println("Warning: Invalid comfort fee. Set to 0.");
            comfortFee = 0;
        }

        if (surgeMultiplier < 1.0 || surgeMultiplier > 3.0) {
            System.out.println("Warning: Invalid surge multiplier. Set to 1.0.");
            surgeMultiplier = 1.0;
        }

        this.comfortFee = comfortFee;
        this.surgeMultiplier = surgeMultiplier;
    }

    public double getComfortFee() {
        return comfortFee;
    }

    public double getSurgeMultiplier() {
        return surgeMultiplier;
    }

    @Override
    public double calculateFare() {
        return (super.calculateFare() + comfortFee) * surgeMultiplier;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nRide type: Premium"
                + "\nComfort fee: " + comfortFee + " TL"
                + "\nSurge multiplier: " + surgeMultiplier;
    }
}

