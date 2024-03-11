package Semester1.DiceGame;

import java.util.Random;

public class Dice {
    private int numSides;
    private Random random;

    // Constructor
    public Dice(int numSides) {
        if (numSides <= 0) {
            throw new IllegalArgumentException("Number of sides must be greater than 0");
        }
        this.numSides = numSides;
        this.random = new Random();
    }

    // Roll the dice and return the result
    public int roll() {
        return random.nextInt(numSides) + 1; // Adding 1 to include the upper bound
    }

    // Get the number of sides on the dice
    public int getNumSides() {
        return numSides;
    }
}
