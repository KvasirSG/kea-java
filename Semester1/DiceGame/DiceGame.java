package Semester1.DiceGame;

public class DiceGame {
    public static void main(String[] args) {
        Dice die = new Dice(6);

        for (int i = 1; i < 11; i++) {
            int tries = 1;
            int wins = 0;
            while (tries < 4) {

                int side = die.roll();
                System.out.println("Try: " + tries + " - You rolled: " + side);
                if (side == 6) {
                    wins++;
                }
                tries++;
            }
            System.out.println("Game:" + i + " - Your got " + wins + " Six rolls in 3 tries");
        }
    }

}
