package Semester1.Blackjack;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a new game
        Game game = new Game(1000); // Player starts with $1000

        while (game.getPlayerBalance() > 0) {
            ActiveGame(game);
        }

    }

    public static void ActiveGame(Game game) {
        // Ask the player how much they want to bet
        System.out.print("How much do you want to bet?: ");
        // Get the bet from the player with the scanner and add validation for the input
        // to make sure its a positive nuimber and not a letter
        int bet = 0;
        while (bet <= 0) {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a positive number");
                scanner.next();
            }
            bet = scanner.nextInt();
            if (bet <= 0) {
                System.out.println("Please enter a positive number");
            }
        }
        scanner.nextLine(); // Consume the newline character
        // Start the game
        game.start(bet);

        System.out.println("=====================================");
        // Print the player's hand
        System.out.println("Player's hand: " + game.getPlayerHand());
        // Print the value of the player's hand
        System.out.println("Player's hand value: " + game.getPlayerHandValue());
        // Print the dealer's hand
        System.out.println("Dealer's hand: " + game.getDealerHand().get(0)); // Only show the first card
        // Print the value of the dealer's hand
        System.out.println("Dealer's hand value: " + game.getDealerHand().get(0).getValue()); // Only show the value of
                                                                                              // the first card
        System.out.println("=====================================");

        if (game.playerHasBlackjack() && game.dealerHasBlackjack()) {
            endGameDetails(game, "no one");

        } else if (game.playerHasBlackjack() && !game.dealerHasBlackjack()) {// Add the winnings to the player's balance
            System.out.println("Player has Blackjack!");
            System.out.println("Player's balance: " + game.getPlayerBalance());
            endGameDetails(game, "Player");
        } else if (!game.playerHasBlackjack() && game.dealerHasBlackjack()) {
            System.out.println("Dealer has Blackjack!");
            System.out.println("Player's balance: " + game.getPlayerBalance());
            endGameDetails(game, "Dealer");
        } else {
            playerTurn(game);
        }
    }

    public static void playerTurn(Game game) {
        // Ask the player if they want to hit or stand
        System.out.print("Do you want to hit or stand?: ");
        String choice = scanner.nextLine();
        while (choice.equalsIgnoreCase("hit")) {
            game.playerHit();
            System.out.println("=====================================");
            System.out.println("Player's hand: " + game.getPlayerHand());
            System.out.println("Player's hand value: " + game.getPlayerHandValue());

            if (game.playerHasBusted()) {
                System.out.println("Player busts!");
                System.out.println("Player's balance: " + game.getPlayerBalance());
                System.out.println("=====================================");
                break;
            } else {
                System.out.println("=====================================");
            }
            System.out.print("Do you want to hit or stand?: ");
            choice = scanner.nextLine();
        }

        if (!game.playerHasBusted()) {
            game.dealerPlay();
            System.out.println("=====================================");
            System.out.println("Dealer's hand: " + game.getDealerHand());
            System.out.println("Dealer's hand value: " + game.getDealerHandValue());
            if (game.isDealerWin()) {
                endGameDetails(game, "Dealer");
            } else if (game.isPlayerWin()) {
                endGameDetails(game, "Player");
            } else {
                endGameDetails(game, "No one");
            }
            System.out.println("Player's balance: " + game.getPlayerBalance());
            System.out.println("=====================================");
        }

    }

    public static void endGameDetails(Game game, String winner) { // Print the winner and the details of the game
        System.out.println("========End of the game details========");
        System.out.println(winner + " wins!");
        System.out.println("Player's hand: " + game.getPlayerHand());
        System.out.println("Player's hand value: " + game.getPlayerHandValue());
        System.out.println("Dealer's hand: " + game.getDealerHand());
        System.out.println("Dealer's hand value: " + game.getDealerHandValue());
        System.out.println("=====================================");
    }
}
