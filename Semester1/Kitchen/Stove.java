package Semester1.Kitchen;

public class Stove {
    int voltage = 0;
    Flame flame1 = new Flame(1);
    Flame flame2 = new Flame(2);
    Flame flame3 = new Flame(3);
    Flame flame4 = new Flame(4);
    private Flame[] flames = { flame1, flame2, flame3, flame4 };

    public void showVoltage() {
        System.out.println("The voltage is set to: " + voltage + "V");
    }

    public void status() {
        System.out.println("====Stove Status====");
        System.out.println("Stove Powerlevel: " + this.voltage);
        System.out.println("Flame Status:");
        for (Flame flame : flames) {
            if (flame.getLevel() == 0) {
                System.out.println("Flame " + flame.getId() + " is Off");
            } else {
                System.out.println("Flame " + flame.getId() + " is at level " + flame.getLevel());
            }
        }
        System.out.println("====End Status====");
    }
}