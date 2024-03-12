package Semester1.CarTruck;

public class Broker {
    public static void main(String[] args) {
        Car[] cars = new Car[49];
        cars[0] = new Car(1999,40000,"Yellow");
        cars[1] = new Truck(2004,60000,"Black",700,true);
        printCars(cars);
    }
    public static void printCars(Car[] cars){
        for (Car car:cars){
            System.out.println(car);
        }
    }
}
