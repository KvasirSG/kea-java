package Semester1.Blackjack;

import java.util.List;

public class Game {
    // Private member variables to store the deck, player, and dealer
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private int bet;

    // Constructor to initialize the deck, player, and dealer
    public Game(int playerBalance) {
        deck = new Deck();
        player = new Player(playerBalance);
        dealer = new Dealer(0); // Dealer's balance is not used in the game
    }

    // Method to start the game
    public void start(int bet) {
        this.bet = bet;
        deck.shuffle();
        player.clearHand();
        dealer.clearHand();
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
    }

    // Method to get the player's hand
    public List<Card> getPlayerHand() {
        return player.getHand();
    }

    // Method to get the dealer's hand
    public List<Card> getDealerHand() {
        return dealer.getHand();
    }

    // Method to get the value of the player's hand
    public int getPlayerHandValue() {
        return player.getHandValue();
    }

    // Method to get the value of the dealer's hand
    public int getDealerHandValue() {
        return dealer.getHandValue();
    }

    // Method to add a card to the player's hand
    public void playerHit() {
        player.addCard(deck.deal());
    }

    // Method to play the dealer's turn
    public void dealerPlay() {
        dealer.play(deck.deal());
    }

    // Method to check if the player has won
    public boolean isPlayerWin() {
        // Check if the player's hand value is less than or equal to 21, and either the
        // dealer's hand value is greater than 21 or the player's hand value is greater
        // than the dealer's hand value to determine if the player wins.
        if (player.getHandValue() <= 21
                && (dealer.getHandValue() > 21 || player.getHandValue() > dealer.getHandValue())) {
            addWinnings();
            return true;
        } else {
            return false;
        }
    }

    // Method to check if the dealer has won
    public boolean isDealerWin() {
        // Check if the dealer's hand value is less than or equal to 21, and either the
        // player's hand value is greater than 21 or the dealer's hand value is greater
        // than the player's hand value to determine if the dealer wins.
        if (dealer.getHandValue() <= 21
                && (player.getHandValue() > 21 || dealer.getHandValue() > player.getHandValue())) {
            removeLosses();
            return true;
        } else {
            return false;
        }
    }

    // Method to check if the game is a tie
    public boolean isTie() {
        // Check if both the player's and dealer's hand values are less than or equal to
        // 21, and the player's hand value is equal to the dealer's hand value to
        // determine if the game is a tie.
        return player.getHandValue() <= 21 && dealer.getHandValue() <= 21
                && player.getHandValue() == dealer.getHandValue();
    }

    // Method to check if the game is over
    public boolean isGameOver() {
        // Check if the player's hand value is greater than 21 or the dealer's hand
        // value is greater than 21 to determine if the game is over.
        return player.getHandValue() > 21 || dealer.getHandValue() > 21;
    }

    // Method to check if the player has blackjack
    public boolean playerHasBlackjack() {
        // Check if the player's hand value is equal to 21 to determine if the player
        // has blackjack.

        if (player.getHand().size() == 2 && player.getHandValue() == 21 && dealer.getHandValue() != 21) {
            addBlackjackWinnings();
        }
        return player.getHand().size() == 2 && player.getHandValue() == 21;
    }

    // Method to check if the dealer has blackjack
    public boolean dealerHasBlackjack() {
        // Check if the dealer's hand value is equal to 21 to determine if the dealer
        // has blackjack.
        return dealer.getHand().size() == 2 && dealer.getHandValue() == 21;
    }

    // Method to check if the player has busted
    public boolean playerHasBusted() {
        // Check if the player's hand value is greater than 21 to determine if the
        // player has busted.
        if (player.getHandValue() > 21) {
            removeLosses();
            return true;
        } else {
            return false;
        }

    }

    // Method to check if the dealer has busted
    public boolean dealerHasBusted() {
        // Check if the dealer's hand value is greater than 21 to determine if the
        // dealer has busted.
        if (dealer.getHandValue() > 21) {
            addWinnings();
            return true;
        } else {
            return false;
        }
    }

    // Method to get the player's balance
    public int getPlayerBalance() {
        return player.getBalance();
    }

    // Method to add to the player's balance
    public void addPlayerBalance(int amount) {
        player.addBalance(amount);
    }

    // Method to subtract from the player's balance
    public void subtractPlayerBalance(int amount) {
        player.subtractBalance(amount);
    }

    // Method to get the bet amount
    public int getBet() {
        return bet;
    }

    // Method to clear the player's hand
    public void clearPlayerHand() {
        player.clearHand();
    }

    // Method to clear the dealer's hand
    public void clearDealerHand() {
        dealer.clearHand();
    }

    // Method to get the player's hand size
    public int getPlayerHandSize() {
        return player.getHand().size();
    }

    // Method to get the dealer's hand size
    public int getDealerHandSize() {
        return dealer.getHand().size();
    }

    // Method to add to the player's balance
    public void addWinnings() {
        player.addBalance(bet);
    }

    // Method to remove losses from the player's balance
    public void removeLosses() {
        player.subtractBalance(bet);
    }

    // Method to add Blackjack winnings to the player's balance
    public void addBlackjackWinnings() {
        player.addBalance(bet * 3 / 2); // Blackjack pays 3:2
    }
}
