package Semester1.CarTruck;

public class Truck extends  Car{
    private int bruttoLoad;
    private boolean hanger;


    public Truck(int year, int price, String colour, int bruttoLoad, boolean hanger) {
        super(year, price, colour);
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
    public String toString() {
        return "Year: " + getYear() + ", Price: " + getPrice() + ", Color: " + getColour() + ", Gears: " + getGears()+", BruttoLoad: "+getBruttoLoad()+ ", Hanger: "+isHanger();
    }
}
