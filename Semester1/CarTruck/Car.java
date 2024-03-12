package Semester1.CarTruck;

public class Car {
    private int year;
    private int price;
    private String colour;
    private int gears = 5;
    private final CarType carType;

    public Car(int year, int price, String colour, CarType carType){
        this.year=year;
        this.price=price;
        this.colour=colour;
        this.carType = carType;
    }
    public Car(int year, int price, String colour){
        this.year=year;
        this.price=price;
        this.colour=colour;
        this.carType = CarType.CAR;
    }

    // Getters
    public int getGears() {
        return gears;
    }
    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getColour() {
        return colour;
    }
    public CarType getCarType() {
        return carType;
    }
    // Setters

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Type: "+getCarType()+", Year: " + year + ", Price: " + price + ", Color: " + colour + ", Gears: " + gears;
    }

}
