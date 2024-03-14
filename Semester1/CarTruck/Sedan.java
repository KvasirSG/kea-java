package Semester1.CarTruck;
public class Sedan extends Car{
    public Sedan(int year, int price, String colour) {
        super(year, price, colour, CarType.SEDAN);
    }

    @Override
    public void printData() {
        System.out.println(this);
    }
}
