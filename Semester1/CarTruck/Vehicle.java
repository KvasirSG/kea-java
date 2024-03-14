package Semester1.CarTruck;

public interface Vehicle {
    // Getters
    int getYear();
    int getPrice();
    String getColour();
    int getGears();
    CarType getCarType(); // Assuming CarType is applicable to all vehicles, else this could be adjusted.

    // Setters
    void setYear(int year);
    void setPrice(int price);
    void setColour(String colour);
    void setGears(int gears);

    // Other methods that could be common across different vehicles
    String toString(); // Provides a string representation of the vehicle.
}
