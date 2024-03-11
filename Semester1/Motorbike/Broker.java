package Semester1.Motorbike;

import java.util.ArrayList;

public class Broker {
    public static void main(String[] args) {

        // Creating a list of Motorbikes
        ArrayList<MotorBike> motorbikes = new ArrayList<>();
        motorbikes.add(new MotorBike("Honda", "CBR500R", 2022, 500, "Red", 25.5, BikeType.SPORT, "Honda Motor Co.",
                "ABC123", FuelType.PETROL));
        motorbikes.add(new MotorBike("Yamaha", "YZF-R6", 2023, 600, "Blue", 22.8, BikeType.SPORT,
                "Yamaha Motor Corporation", "XYZ789", FuelType.PETROL));
        motorbikes.add(new MotorBike("Kawasaki", "Ninja 650", 2021, 650, "Green", 20.3, BikeType.SPORT,
                "Kawasaki Heavy Industries", "DEF456", FuelType.PETROL));

        // Using a switch statement to perform actions based on motorbike types
        for (MotorBike motorbike : motorbikes) {
            switch (motorbike.getType()) {
                case SPORT:
                    System.out.println(
                            "Performing sporty actions for " + motorbike.getBrand() + " " + motorbike.getModel());
                    // TODO: Additional actions specific to SPORT type
                    break;
                case CRUISER:
                    System.out.println(
                            "Performing cruiser actions for " + motorbike.getBrand() + " " + motorbike.getModel());
                    // TODO: Additional actions specific to CRUISER type
                    break;
                case TOURING:
                    System.out.println(
                            "Performing touring actions for " + motorbike.getBrand() + " " + motorbike.getModel());
                    // TODO: Additional actions specific to TOURING type
                    break;
                case OFFROAD:
                    System.out.println(
                            "Performing off-road actions for " + motorbike.getBrand() + " " + motorbike.getModel());
                    // TODO: Additional actions specific to OFFROAD type
                    break;
                default:
                    System.out
                            .println("Unknown motorbike type for " + motorbike.getBrand() + " " + motorbike.getModel());
                    break;
            }
        }

        // Using a for loop to display information for each motorbike
        for (MotorBike motorbike : motorbikes) {
            motorbike.displayInfo();
        }
    }
}
