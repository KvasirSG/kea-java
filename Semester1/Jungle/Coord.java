package Semester1.Jungle;

import java.util.Random;

/**
 * The Coord class contains a set of X and Y values to make a coordinate for a
 * x,y grid
 */
public class Coord {
    private int x;
    private int y;

    /** Constructer for the Coord class based on x and y values */
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructer for the coord class provides random x and y values based on grid
     * size
     * 
     * @param random
     */
    public Coord(int random) {
        Random rnd = new Random();
        x = rnd.nextInt(random) + 1;
        y = rnd.nextInt(random) + 1;
    }

    /**
     * Get the X value
     * 
     * @return X value
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getCoords() {
        return new int[] { x, y };
    }
}
