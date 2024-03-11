package Semester1.Motorbike;

// Enum for fuel types
enum FuelType {
    PETROL, DIESEL, ELECTRIC
}

public class Vehicle implements VehicleInterface {
    private String manufacturer;
    private String registrationNumber;
    private FuelType fuelType;
    private boolean lightsOn;

    // Constructor
    public Vehicle(String manufacturer, String registrationNumber, FuelType fuelType) {
        this.manufacturer = manufacturer;
        this.registrationNumber = registrationNumber;
        this.fuelType = fuelType;
        this.lightsOn = false; // Lights are initially off
    }

    // Getter and setter methods

    public String getManufacturer() {
        return manufacturer;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public boolean areLightsOn() {
        return lightsOn;
    }

    // Behavioral methods

    public void turnOnLights() {
        lightsOn = true;
        System.out.println("Lights are now on.");
    }

    public void turnOffLights() {
        lightsOn = false;
        System.out.println("Lights are now off.");
    }

    // Display vehicle information
    public void displayInfo() {
        System.out.println("Vehicle: " + manufacturer + ", Registration Number: " + registrationNumber +
                ", Fuel Type: " + fuelType + ", Lights On: " + lightsOn);
    }
}