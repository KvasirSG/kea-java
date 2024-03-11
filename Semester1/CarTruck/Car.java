package Semester1.CarTruck;

public class Car {
    private int year;
    private int price;
    private String colour;
    private int gears = 5;

    public Car(int year, int price, String colour){
        this.year=year;
        this.price=price;
        this.colour=colour;
    }
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
}
