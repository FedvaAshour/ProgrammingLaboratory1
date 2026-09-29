
package week2;

import java.util.Scanner;


public class Week2 {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        // 1. Number of stops
        System.out.print("Enter number of stops: ");
        int numberOfStops = input.nextInt();
        input.nextLine();

        // Arrays
        String[] stopNames = new String[numberOfStops];
        int[] boarding = new int[numberOfStops];
        int[] alighting = new int[numberOfStops];
        int[] occupancy = new int[numberOfStops];

        // Bus capacity
        System.out.print("Enter bus seating capacity: ");
        int capacity = input.nextInt();
        input.nextLine();

        
        for (int i = 0; i < numberOfStops; i++) {

            System.out.println("\nStop " + (i + 1));

            System.out.print("Enter stop name: ");
            stopNames[i] = input.nextLine();

            System.out.print("Passengers boarding: ");
            boarding[i] = input.nextInt();

            System.out.print("Passengers alighting: ");
            alighting[i] = input.nextInt();

            input.nextLine();
        }

        // 3. Occupancy calculation
        int currentPassengers = 0;
        int overCapacityCount = 0;
        int totalOccupancy = 0;

        for (int i = 0; i < numberOfStops; i++) {

            // Check if too many passengers get off
            if (alighting[i] > currentPassengers + boarding[i]) {

                System.out.println(
                    "Data error at " + stopNames[i]
                    + ": cannot have more passengers alighting than are currently on the bus. Occupancy set to 0."
                );

                currentPassengers = 0;

            } else {

                currentPassengers = currentPassengers + boarding[i] - alighting[i];
            }

            occupancy[i] = currentPassengers;

            System.out.println(
                "Passengers after " + stopNames[i] + ": "
                + currentPassengers
            );

            // Capacity check
            if (currentPassengers > capacity) {

                System.out.println(
                    "Warning: Bus is over capacity at "
                    + stopNames[i] + "!"
                );

                overCapacityCount++;
            }

            totalOccupancy += currentPassengers;
        }

        // 4. Display All
        System.out.println("\n===== ALL STOPS =====");

        for (int i = 0; i < numberOfStops; i++) {

            System.out.println(
                "Stop: " + stopNames[i]
                + " | Boarding: " + boarding[i]
                + " | Alighting: " + alighting[i]
                + " | Occupancy: " + occupancy[i]
            );
        }

        // 5. Busiest stop
        int busiestIndex = 0;

        for (int i = 1; i < numberOfStops; i++) {

            if (boarding[i] > boarding[busiestIndex]) {
                busiestIndex = i;
            }
        }

        // 6. Average occupancy
        double averageOccupancy = (double) totalOccupancy / numberOfStops;

        // 7. Statistics
        System.out.println("\n===== STATISTICS =====");

        System.out.println(
            "Busiest stop: " + stopNames[busiestIndex]
            + " (" + boarding[busiestIndex] + " passengers boarding)"
        );

        System.out.println(
            "Average occupancy: " + averageOccupancy
        );

        System.out.println(
            "Number of stops over capacity: "
            + overCapacityCount
        );

        // 8. Final occupancy check
        if (currentPassengers != 0) {

            System.out.println(
                "Warning: " + currentPassengers
                + " passengers still on the bus after the final stop — please check your data."
            );

        } else {

            System.out.println(
                "Final occupancy is 0. All passengers got off the bus."
            );
        }

        input.close();
    }
    
}
