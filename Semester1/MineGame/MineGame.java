package Semester1.MineGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MineGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean play = true;
        while (play) {
            playGame(10, 10);
            boolean validation = false;
            while (!validation) {
                try {
                    System.out.print("Would you like to start a new game?(y/n): ");
                    String input = scn.nextLine();
                    System.out.println();
                    switch (input.toUpperCase()) {
                        case "Y":
                            validation = true;
                            play = true;
                            break;
                        case "N":
                            validation = true;
                            play = false;
                            break;
                        default:
                            break;
                    }
                } catch (InputMismatchException e) {
                    scn.next();
                }
            }

        }

    }

    /**
     * This method initiates and controls the gameplay for a minefield game. The
     * game is played on a grid where mines are randomly placed, and the player
     * navigates through the field trying to avoid them.
     *
     * @param fieldSize     The size of the game field. This parameter could be used
     *                      to define the dimensions of the game grid.
     * @param amountOfMines The number of mines to be placed on the game field. This
     *                      parameter determines how many mines will be randomly
     *                      placed on the grid.
     */
    public static void playGame(int fieldSize, int amountOfMines) {
        Random rnd = new Random();
        Field gamField = new Field(fieldSize);
        Scanner scn = new Scanner(System.in);
        boolean quit = false;
        for (int i = 0; i < amountOfMines; i++) {
            boolean check = false;
            while (!check) {
                int x = rnd.nextInt(fieldSize + 1);
                int y = rnd.nextInt(fieldSize + 1);
                if (x == gamField.getPlayerPosition().getX() && y == gamField.getPlayerPosition().getY()) {
                    continue;
                }
                if (!gamField.getCoord(x, y).hasMine()) {
                    check = true;
                    gamField.placeMineAt(x, y);
                }
            }
        }
        while (!quit) {
            gamField.revealAdjacentMines();
            gamField.printGameField();
            System.out.print("Your Move: ");
            int input;
            try {
                input = scn.nextInt();
                Coord playerPos = gamField.getPlayerPosition();
                switch (input) {
                    case 8:
                        if (!gamField.movePlayerTo(playerPos.getX(), playerPos.getY() + 1)) {
                            quit = true;
                        }
                        break;
                    case 4:
                        if (!gamField.movePlayerTo(playerPos.getX() - 1, playerPos.getY())) {
                            quit = true;
                        }
                        break;
                    case 5:
                        quit = true;
                        break;
                    case 6:
                        if (!gamField.movePlayerTo(playerPos.getX() + 1, playerPos.getY())) {
                            quit = true;
                        }
                        break;
                    case 2:
                        if (!gamField.movePlayerTo(playerPos.getX(), playerPos.getY() - 1)) {
                            quit = true;
                        }
                        break;
                    default:
                        System.out.println("You can move with 8, 4, 6 and 2. Quit with 5");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("input was not a number try again!");
                scn.next();

            }
        }
    }
}
