package Semester1.CarTruck;

public class Coupe extends Car{
    public Coupe(int year, int price, String colour) {
        super(year, price, colour, CarType.COUPE);
    }

    @Override
    public void printData() {
        System.out.println(this);
    }
}
