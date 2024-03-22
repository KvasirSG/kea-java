package Semester1.MineGame;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a single cell in the mine game field. It extends JButton to allow visual representation and interaction.
 * Each cell can have different states such as being a mine, being close to a mine, being the player's position,
 * being the goal, or being the player's starting point.
 */
public class Coord extends JButton {
    private boolean isMine = false; // Flag for whether this cell is a mine
    private boolean isPlayer = false; // Flag for whether this cell is the player's current position

    private boolean isMineClose = false; // Flag for whether a mine is close to this cell
    private int x; // X-coordinate of this cell in the grid
    private int y; // Y-coordinate of this cell in the grid
    private boolean isGoal= false; // Flag for whether this cell is the goal
    private boolean isPlayerStart = false; // Flag for whether this cell is the player's starting position

    /**
     * Constructs a Coord object with specified x and y coordinates.
     * Initializes the button's appearance and disables it by default.
     *
     * @param x The x-coordinate of the cell in the grid.
     * @param y The y-coordinate of the cell in the grid.
     */
    public Coord(int x, int y){
        super();
        setSize(10,10); // Set the button size (this may not be necessary depending on layout manager)
        this.x = x;
        this.y = y;
        setText("X"); // Initial text for the button
        setBackground(Color.white); // Initial background color
        setEnabled(false); // By default, the cell is not clickable
    }

    // Getter for the isMine flag
    public boolean isMine() {
        return isMine;
    }

    // Setter for the isMine flag
    public void setMine(boolean mine) {
        if (mine) {
            // If this cell is a mine, customize its appearance here if needed
        }else {
            reset(); // Reset the cell if it's not a mine
        }
        isMine = mine;
    }

    // Getter for the isPlayer flag
    public boolean isPlayer() {
        return isPlayer;
    }

    // Setter for the isPlayer flag
    public void setPlayer(boolean player) {
        if (player){
            setText("P"); // Indicate the player's position
            // Change the cell's background color based on the game state
            if (!isGoal){
                if (isMineClose){
                    setBackground(Color.yellow); // Mine is close
                }else {
                    setBackground(Color.blue); // No mine is close
                }
            }else{
                setBackground(Color.green); // This cell is the goal
            }
        } else {
            reset(); // Reset the cell if it's no longer the player's position
        }
        isPlayer = player;
    }

    // Getters for the x and y coordinates
    public int getCoordX() {
        return x;
    }

    public int getCoordY(){
        return y;
    }

    // Getter and setter for the isGoal flag
    public boolean isGoal() {
        return isGoal;
    }

    public void setGoal(boolean goal) {
        isGoal = goal;
    }

    // Getter and setter for the isPlayerStart flag
    public boolean isPlayerStart() {
        return isPlayerStart;
    }

    public void setPlayerStart(boolean playerStart) {
        isPlayerStart = playerStart;
    }

    /**
     * Resets the cell to its default state, clearing all flags and resetting its appearance.
     */
    public void reset(){
        isMine = false;
        isGoal = false;
        isPlayer= false;
        isPlayerStart = false;
        isMineClose = false;
        setText("X"); // Reset text
        setBackground(Color.white); // Reset background color
    }

    // Getter and setter for the isMineClose flag
    public boolean isMineClose() {
        return isMineClose;
    }

    public void setMineClose(boolean mineClose) {
        isMineClose = mineClose;
    }
}
