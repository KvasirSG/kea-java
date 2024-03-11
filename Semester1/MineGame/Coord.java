package Semester1.MineGame;

import java.io.Serializable;

/**
 * Represents a single coordinate on a minefield grid.
 * It stores the coordinate's position (x, y) and whether it contains a mine.
 */
public class Coord implements Serializable {
    private int x;
    private int y;
    private boolean hasMine;
    private boolean revealed;
    private boolean hasPlayer;

    /**
     * Constructs a Coord object with specified x and y positions.
     * 
     * @param x The x position of the coordinate.
     * @param y The y position of the coordinate.
     */
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
        this.hasMine = false;
        this.revealed = false;
        this.hasPlayer = false;
    }

    /**
     * Places a mine at this coordinate.
     */
    public void placeMine() {
        this.hasMine = true;
    }

    /**
     * Checks if this coordinate has a mine.
     * 
     * @return True if there is a mine, false otherwise.
     */
    public boolean hasMine() {
        return hasMine;
    }

    /**
     * Reveals this coordinate.
     */
    public void reveal() {
        this.revealed = true;
    }

    /**
     * Checks if this coordinate is revealed.
     * 
     * @return True if the coordinate is revealed, false otherwise.
     */
    public boolean isRevealed() {
        return revealed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPlayer() {
        hasPlayer = true;
    }

    public boolean isPlayer() {
        return hasPlayer;
    }

    public void removePlayer() {
        hasPlayer = false;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                ", hasMine=" + hasMine +
                '}';
    }
}
