package Semester1.WalkAbout;

import java.util.Scanner;

public class WalkAbout {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        boolean quit = false;

        while (!quit) {
            System.out.println("You are on: (" + player.getCoord().getX() + "," + player.getCoord().getY() + ")");
            System.out.print("Your turn: ");
            int move = scanner.nextInt();
            scanner.nextLine();
            switch (move) {
                case 8:
                    if (player.getCoord().getY() < 10) {
                        player.getCoord().setY(player.getCoord().getY() + 1);
                    } else {
                        System.out.println("I am sorry Dave! I am afraid you cannot do that!");
                    }

                    break;
                case 2:
                    if (player.getCoord().getY() > 0) {
                        player.getCoord().setY(player.getCoord().getY() - 1);
                    } else {
                        System.out.println("I am sorry Dave! I am afraid you cannot do that!");
                    }
                    break;
                case 4:
                    if (player.getCoord().getX() > 0) {
                        player.getCoord().setX(player.getCoord().getX() - 1);
                    } else {
                        System.out.println("I am sorry Dave! I am afraid you cannot do that!");
                    }
                    break;
                case 6:
                    if (player.getCoord().getX() < 10) {
                        player.getCoord().setX(player.getCoord().getX() + 1);
                    } else {
                        System.out.println("I am sorry Dave! I am afraid you cannot do that!");
                    }
                    break;
                case 5:
                    quit = true;
                    break;

                case 7:
                    if (player.getCoord().getY() < 10 && player.getCoord().getX() > 0) {
                        player.getCoord().setY(player.getCoord().getY() + 1);
                        player.getCoord().setX(player.getCoord().getX() - 1);

                    } else {
                        System.out.println("I am sorry Dave! I am afraid you cannot do that!");
                    }
                    break;

                case 9:
                    if (player.getCoord().getY() < 10 && player.getCoord().getX() < 10) {
                        player.getCoord().setY(player.getCoord().getY() + 1);
                        player.getCoord().setX(player.getCoord().getX() + 1);

                    } else {
                        System.out.println("I am sorry Dave! I am afraid you cannot do that!");
                    }
                    break;

                case 1:
                    if (player.getCoord().getY() > 0 && player.getCoord().getX() > 0) {
                        player.getCoord().setY(player.getCoord().getY() - 1);
                        player.getCoord().setX(player.getCoord().getX() - 1);

                    } else {
                        System.out.println("I am sorry Dave! I am afraid you cannot do that!");
                    }
                    break;

                case 3:
                    if (player.getCoord().getY() > 0 && player.getCoord().getX() < 10) {
                        player.getCoord().setY(player.getCoord().getY() - 1);
                        player.getCoord().setX(player.getCoord().getX() + 1);

                    } else {
                        System.out.println("I am sorry Dave! I am afraid you cannot do that!");
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
