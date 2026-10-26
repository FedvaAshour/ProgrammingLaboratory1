
package week6;


class EconomyRide extends Ride {
    private double pricePerMinute;

    public EconomyRide(String passengerName, String pickup,
                       String destination, double distanceKm,
                       int durationMin, double pricePerKm,
                       double pricePerMinute) {

        super(passengerName, pickup, destination,
                distanceKm, durationMin, pricePerKm);

        if (pricePerMinute <= 0) {
            System.out.println("Warning: Invalid price per minute. Set to 1.");
            pricePerMinute = 1;
        }

        this.pricePerMinute = pricePerMinute;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    @Override
    public double calculateFare() {
        double fare = super.calculateFare()
                + getDurationMin() * pricePerMinute;

        if (fare < 50) {
            return 50;
        }

        return fare;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nRide type: Economy"
                + "\nPrice per minute: " + pricePerMinute + " TL";
    }
}