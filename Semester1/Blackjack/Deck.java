package Semester1.Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    // Private member variable to store the cards in the deck
    private List<Card> cards;

    // Constructor to initialize the deck with 52 cards
    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Method to shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to deal a card from the deck
    public Card deal() {
        return cards.remove(0);
    }
}
