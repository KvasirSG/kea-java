package Semester1.Kitchen;

public class Kitchen {
    public static void main(String[] args) {
        Stove myStove = new Stove();
        myStove.voltage = 220;
        myStove.showVoltage();
        myStove.flame2.setLevel(3);
        // myStove.flame2.cooking();
        myStove.status();
        myStove.flame3.setLevel(4);
        myStove.status();
    }
}