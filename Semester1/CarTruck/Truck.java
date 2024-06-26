package Semester1.CarTruck;

public class Truck extends  Car{
    private int bruttoLoad;
    private boolean hanger;


    public Truck(int year, int price, String colour, int bruttoLoad, boolean hanger) {
        super(year, price, colour,CarType.TRUCK);
        this.bruttoLoad = bruttoLoad;
        this.hanger = hanger;
    }

    public int getBruttoLoad() {
        return bruttoLoad;
    }

    public void setBruttoLoad(int bruttoLoad) {
        this.bruttoLoad = bruttoLoad;
    }

    public boolean isHanger() {
        return hanger;
    }

    public void setHanger(boolean hanger) {
        this.hanger = hanger;
    }

    @Override
    public void printData() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString()+", BruttoLoad: "+getBruttoLoad()+", Hanger: "+isHanger();
    }
}
