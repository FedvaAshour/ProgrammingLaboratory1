
package week6;

import java.util.ArrayList;

public class Week6 {

   
    public static void main(String[] args) {
        ArrayList<Ride> rides = new ArrayList<>();

        Ride ride1 = new Ride(
                "Ali", "Kayseri Center", "University",
                10, 20, 8);

        EconomyRide ride2 = new EconomyRide(
                "Ayse", "Home", "Work",
                5, 15, 8, 2);

        PremiumRide ride3 = new PremiumRide(
                "Mehmet", "Airport", "Hotel",
                20, 30, 10, 50, 1.5);

        SharedRide ride4 = new SharedRide(
                "Zeynep", "Mall", "University",
                12, 25, 7, 2, 3);

        rides.add(ride1);
        rides.add(ride2);
        rides.add(ride3);
        rides.add(ride4);

        for (Ride ride : rides) {
            System.out.println("========================");
            System.out.println(ride.toString());
                      
    }
    
}
}
