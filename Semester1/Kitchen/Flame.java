package Semester1.Kitchen;

public class Flame {
    private int level = 0;
    private int id;

    public Flame(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public int getId() {
        return this.id;
    }

    public void cooking() {
        System.out.println("Flame " + this.id + " is Cooking at level: " + level);
    }
}
