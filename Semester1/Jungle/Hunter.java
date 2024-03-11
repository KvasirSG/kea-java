package Semester1.Jungle;

public class Hunter {
    private String name;
    private Coord coord;

    public Hunter(String name) {
        this.name = name;
        coord = new Coord(100);
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }
}
