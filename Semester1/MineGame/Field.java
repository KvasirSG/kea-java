package Semester1.MineGame;

/**
 * Manages the minefield grid and player interactions with the field.
 */
public class Field {
    private Coord[][] grid;
    private Player player;
    private int size = 0;

    public Field() {
        this(10);
    }

    public Field(int size) {
        this.size = size + 1; // fix for having it 0 to size
        if (this.size < 11) {
            System.out.println("The minimum allowed size is 10x10 so we corrected for it!");
            this.size = 11;
        }
        grid = new Coord[this.size][this.size];
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                grid[x][y] = new Coord(x, y);
            }
        }
        // Initialize player at a starting position, for example (1, 1)
        player = new Player(1, 1);
        grid[player.getX()][player.getY()].setPlayer();
    }

    /**
     * Places a mine at the specified coordinate.
     * 
     * @param x The x position where the mine should be placed.
     * @param y The y position where the mine should be placed.
     */
    public void placeMineAt(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            grid[x][y].placeMine();
        }
    }

    /**
     * Retrieves the Coord object at the specified coordinate.
     * 
     * @param x The x position of the coordinate.
     * @param y The y position of the coordinate.
     * @return The Coord object at the specified position, or null if out of bounds.
     */
    public Coord getCoord(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return grid[x][y];
        } else {
            return null;
        }
    }

    /**
     * Reveals the coordinate at the specified position.
     * 
     * @param x The x position of the coordinate to reveal.
     * @param y The y position of the coordinate to reveal.
     */
    public void reveal(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            grid[x][y].reveal();
        }
    }

    /**
     * Prints the current state of the field to the console for debugging purposes.
     */
    public void printField() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.print(grid[x][y].hasMine() ? "* " : ". ");
            }
            System.out.println();
        }
    }

    /**
     * Moves the player to the specified position if it is within the field bounds.
     * 
     * @param newX The new x position for the player.
     * @param newY The new y position for the player.
     * @return True if the move is successful, false if out of bounds or on a mine.
     */
    public boolean movePlayerTo(int newX, int newY) {
        if (newX >= 0 && newX < size && newY >= 0 && newY < size) {
            grid[player.getX()][player.getY()].removePlayer();
            player.moveTo(newX, newY);
            grid[player.getX()][player.getY()].setPlayer();
            if (grid[newX][newY].hasMine()) {
                System.out.println("Game Over! Stepped on a mine.");
                return false; // Game over condition
            }
            return true;
        } else {
            System.out.println("Move out of bounds.");
            return true;
        }
    }

    /**
     * Gets the current position of the player.
     * 
     * @return The current position of the player as a Coord object.
     */
    public Coord getPlayerPosition() {
        return grid[player.getX()][player.getY()];
    }

    /**
     * Prints the game field from the player's perspective.
     * Revealed cells, the player's position, and unrevealed cells are distinctly
     * marked.
     */
    public void printGameField() {
        for (int y = size - 1; y >= 0; y--) {
            for (int x = 0; x < size; x++) {
                if (grid[x][y].isPlayer()) {
                    System.out.print("P "); // Representing the player's position
                } else if (grid[x][y].isRevealed()) {
                    // Assume we reveal whether a cell has a mine for simplicity
                    // In a real game, you might show hints (like adjacent mine counts) instead
                    System.out.print(grid[x][y].hasMine() ? ". " : "o ");
                } else {
                    System.out.print(". "); // Unrevealed cells
                }
            }
            System.out.println();
        }
    }

    /**
     * Reveals mines in the cells adjacent to the player's current position.
     * This method assumes an 8-direction check (up, down, left, right, and
     * diagonals).
     */
    public void revealAdjacentMines() {
        int[] directions = { -1, 0, 1 }; // Used to check adjacent cells in all directions

        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0) {
                    continue; // Skip the player's own position
                }
                int newX = player.getX() + dx;
                int newY = player.getY() + dy;

                // Check bounds and reveal if it's a mine
                if (newX >= 0 && newX < size && newY >= 0 && newY < size) {
                    Coord adjacentCoord = grid[newX][newY];
                    if (adjacentCoord.hasMine()) {
                        adjacentCoord.reveal(); // Reveals the mine
                        System.out.println("ALERT!!! MINE NEARBY!!!");
                    }
                }
            }
        }
    }

}
