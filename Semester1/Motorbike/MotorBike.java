package Semester1.Motorbike;

// Enum for bike types
enum BikeType {
    SPORT, CRUISER, TOURING, OFFROAD
}

public class MotorBike extends Vehicle {
    // attributes
    private String brand;
    private String model;
    private int year;
    private int engineCapacity;
    private String color;
    private double mileage;
    private BikeType type;

    // Constructor
    public MotorBike(String brand, String model, int year, int engineCapacity, String color, double mileage,
            BikeType type, String manufacturer, String registrationNumber, FuelType fuelType) {
        // Call the constructor of the superclass (Vehicle)
        super(manufacturer, registrationNumber, fuelType);

        // Set Motorbike-specific attributes
        this.brand = brand;
        this.model = model;
        setYear(year); // Using setter with validation
        this.engineCapacity = engineCapacity;
        this.color = color;
        this.mileage = mileage;
        this.type = type;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public String getColor() {
        return color;
    }

    public double getMileage() {
        return mileage;
    }

    public BikeType getType() {
        return type;
    }

    // Setter methods
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        if (year >= 1900 && year <= 2024) {
            this.year = year;
        } else {
            System.out.println("Invalid year. Please enter a valid year.");
        }
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    // Override displayInfo method to include both Vehicle and Motorbike information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo method of the superclass (Vehicle)
        System.out.println("Motorbike: " + year + " " + brand + " " + model + " (" + type + "), Color: " + color
                + ", Engine Capacity: " + engineCapacity + "cc, Mileage: " + mileage + " km/l");
    }
}
