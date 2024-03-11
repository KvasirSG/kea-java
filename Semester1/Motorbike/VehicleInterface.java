package Semester1.Motorbike;

public interface VehicleInterface {
    // Getter and setter methods
    String getManufacturer();

    String getRegistrationNumber();

    FuelType getFuelType();

    boolean areLightsOn();

    // Behavioral methods
    void turnOnLights();

    void turnOffLights();

    // Display vehicle information
    void displayInfo();
}
