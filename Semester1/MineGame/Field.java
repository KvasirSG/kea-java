package Semester1.MineGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

// Enum defining possible directions for player movement
enum PlayerMoveDirection{
    UP,RIGHT,LEFT,DOWN
}

/**
 * This class represents the playing field for the mine game. It manages the grid layout, player movement,
 * mine placement, and interactions between the player and the game environment.
 */
public class Field extends JPanel {
    private Coord[][] grid; // 2D array representing the grid of coordinates
    private int fieldSize; // Size of the field (number of squares in one dimension)
    private int mineAmount; // Total number of mines to be placed on the field
    private Coord player; // Current player position
    private Coord goal; // Goal position

    /**
     * Constructor for creating a new Field.
     * Initializes the grid based on the specified field size, populates it with Coords, and sets up the game.
     *
     * @param fieldSize Size of one side of the square grid.
     * @param mineAmount The number of mines to be randomly placed on the field.
     */
    public Field(int fieldSize, int mineAmount){
        super(new GridLayout(fieldSize,fieldSize)); // Set up the panel with a grid layout
        this.fieldSize = fieldSize;
        this.mineAmount = mineAmount;

        // Initialize and populate the grid with Coord objects
        grid = new Coord[fieldSize][fieldSize];
        for (int y = this.fieldSize-1; y >= 0; y--) {
            for (int x = 0; x < this.fieldSize; x++) {
                Coord coord = new Coord(x,y);
                grid[x][y] = coord;
                add(coord); // Add Coord components to the panel
            }
        }
        setup(); // Set up the initial game state
        revalidate();
        repaint(); // Redraw the panel
    }

    /**
     * Moves the player in the specified direction if possible.
     *
     * @param playerMoveDirection The direction in which the player attempts to move.
     */
    public void movePlayer(PlayerMoveDirection playerMoveDirection){
        switch (playerMoveDirection){
            case UP:
                assignPlayer(player.getCoordX(), player.getCoordY()+1);
                break;
            case DOWN:
                assignPlayer(player.getCoordX(), player.getCoordY()-1);
                break;
            case LEFT:
                assignPlayer(player.getCoordX()-1, player.getCoordY());
                break;
            case RIGHT:
                assignPlayer(player.getCoordX()+1, player.getCoordY());
                break;
        }
    }

    /**
     * Randomly places mines on the field, avoiding the player start and goal positions.
     */
    public void randomPlaceMine(){
        for (int i = 0; i < mineAmount; i++) {
            while (true){
                Random rnd = new Random();
                int mineX = rnd.nextInt(fieldSize);
                int mineY = rnd.nextInt(fieldSize);
                try{
                    placeMine(mineX,mineY);
                    break;
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Places a mine at the specified coordinates if it's a valid location.
     *
     * @param x The x coordinate for the mine placement.
     * @param y The y coordinate for the mine placement.
     * @throws IllegalArgumentException if the placement is not valid.
     */
    public void placeMine(int x, int y) throws IllegalArgumentException {
        if (grid[x][y].isPlayerStart()||grid[x][y].isGoal()){
            throw new IllegalArgumentException("Cannot place mine on Player Start or Goal");
        } else if (grid[x][y].isMine()){
            throw new IllegalArgumentException("Cannot place a mine on an already placed mine coord");
        } else {
            grid[x][y].setMine(true);
        }
    }

    /**
     * Assigns the player to a new position, if valid, and handles game logic like mine detection.
     *
     * @param px New player x-coordinate.
     * @param py New player y-coordinate.
     */
    public void assignPlayer(int px, int py){
        if (px >= 0 && px < fieldSize && py >= 0 && py < fieldSize){
            player.setPlayer(false); // Remove player from current position
            player = grid[px][py]; // Move player to new position
            if (!player.isMine()){
                revealAdjacentMines(); // Check for adjacent mines
                player.setPlayer(true); // Set player at new position
            }else {
                reset(); // Reset the game if the player hits a mine
            }

        }
    }

    /**
     * Sets the starting position for the player and initializes the player's location.
     * Also, it checks for adjacent mines from the start position.
     *
     * @param x The x-coordinate of the player's starting position.
     * @param y The y-coordinate of the player's starting position.
     */
    public void setPlayerStart(int x, int y){
        player = grid[x][y]; // Set the player's starting position
        revealAdjacentMines(); // Check for adjacent mines
        player.setPlayerStart(true); // Mark this position as the player's start
        player.setPlayer(true); // Mark this position as currently containing the player
    }

    /**
     * Sets the goal position on the field. By default, the goal is placed at the opposite corner from the start.
     */
    public void setGoal() {
        goal = grid[fieldSize-1][fieldSize-1]; // Place the goal in the bottom-right corner
        goal.setGoal(true); // Mark this position as the goal
    }

    /**
     * Resets the field to its initial state by clearing all mines, goals, and player positions, then re-initializing the game setup.
     */
    public void reset(){
        // Clear all Coord states in the grid
        for (Coord[] coords : grid){
            for (Coord point : coords){
                point.reset();
            }
        }
        setup(); // Re-setup the game
    }

    /**
     * Performs initial game setup including placing the goal, setting the player's start position, and placing mines.
     */
    public void setup(){
        setGoal(); // Set the goal position
        setPlayerStart(1,1); // Set the player's start position
        randomPlaceMine(); // Place mines randomly on the field
    }

    /**
     * Reveals if there are mines in cells adjacent to the player's current position.
     * This check includes all eight surrounding cells.
     */
    public void revealAdjacentMines() {
        int[] directions = {-1, 0, 1}; // Array to iterate through adjacent cells in all directions
        ArrayList<Coord> adjacentCoords = new ArrayList<>();
        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0) {
                    continue; // Skip the player's current cell
                }
                int newX = player.getCoordX() + dx;
                int newY = player.getCoordY() + dy;

                // Check if the new coordinates are within bounds
                if (newX >= 0 && newX < fieldSize && newY >= 0 && newY < fieldSize) {
                    Coord adjacentCoord = grid[newX][newY];
                    if (adjacentCoord.isMine()) {
                        adjacentCoords.add(adjacentCoord); // Add if there's a mine
                    }
                }
            }
        }
        // If there are adjacent mines, notify the player or take necessary action
        if (!adjacentCoords.isEmpty()) {
            player.setMineClose(true); // Notify that a mine is close
        }
    }
}
