package Semester1.Blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // Private member variable to store the cards in the player's hand
    private List<Card> hand;
    private int balance;

    // Constructor to initialize the player's hand
    public Player(int balance) {
        hand = new ArrayList<>();
        this.balance = balance;
    }

    // Method to add a card to the player's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    // Method to get the value of the player's hand
    public int getHandValue() {
        int value = 0;
        int aces = 0;
        for (Card card : hand) {
            value += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aces++;
            }
        }
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }

    // Method to get the player's hand
    public List<Card> getHand() {
        return hand;
    }

    // Method to clear the player's hand
    public void clearHand() {
        hand.clear();
    }

    // Method to get the player's balance
    public int getBalance() {
        return balance;
    }

    // Method to add to the player's balance
    public void addBalance(int amount) {
        balance += amount;
    }

    // Method to subtract from the player's balance
    public void subtractBalance(int amount) {
        balance -= amount;
    }
}
