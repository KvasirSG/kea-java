package Semester1.MineGame;

/**
 * Represents a player in the minefield game.
 * Stores the player's current position and provides methods to move the player.
 */
public class Player {
    private int x;
    private int y;

    /**
     * Constructs a Player object at the specified starting position.
     * 
     * @param startX The starting x position of the player.
     * @param startY The starting y position of the player.
     */
    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    /**
     * Moves the player to a new position.
     * 
     * @param newX The new x position of the player.
     * @param newY The new y position of the player.
     */
    public void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Gets the current x position of the player.
     * 
     * @return The x position.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the current y position of the player.
     * 
     * @return The y position.
     */
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Player{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
