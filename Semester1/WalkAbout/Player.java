package Semester1.WalkAbout;

public class Player {
    private Coord coord = null;

    public Player() {
        coord = new Coord(5, 5);
    }

    public Coord getCoord() {
        return coord;
    }
}
