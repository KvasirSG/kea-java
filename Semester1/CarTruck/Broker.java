package Semester1.CarTruck;

public class Broker {
    public static void main(String[] args) {
        Car[] cars = new Car[6];
        cars[1] = new Truck(2004,60000,"Black",700,true);
        cars[2] = new PickUp(2002,80000,"Blue");
        printCars(cars);
    }
    public static void printCars(Car[] cars){
        for (Car car:cars){
            if (car!=null)
                System.out.println(car);
        }
    }
}
