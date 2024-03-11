package Semester1.DiceGame;

import java.util.ArrayList;
import java.util.List;

public class DiceCup {
    private List<Dice> dice = new ArrayList<>();
    List<Integer> values = new ArrayList<>();

    public DiceCup(int diceType, int numberOfDice) {
        if (numberOfDice <= 0) {
            throw new IllegalArgumentException("Number of sides must be greater than 0");
        }
        for (int i = 1; i <= numberOfDice; i++) {
            dice.add(new Dice(diceType));
        }
    }

    public void shuffle() {

        values.clear();
        for (Dice die : dice) {
            values.add(die.roll());
        }
    }

    public int getValue() {
        int value = 0;
        for (int v : values) {
            value += v;
        }
        return value;
    }

    public List<Integer> getValues() {
        return values;
    }
}
