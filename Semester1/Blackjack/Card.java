package Semester1.Blackjack;

enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

public class Card {
    // Private member variables to store the suit and rank of the card
    private Suit suit;
    private Rank rank;

    // Constructor to initialize a card with a given suit and rank
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter method to get the suit of the card
    public Suit getSuit() {
        return suit;
    }

    // Getter method to get the rank of the card
    public Rank getRank() {
        return rank;
    }

    // Method to get the value of the card
    public int getValue() {
        switch (rank) {
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            case ACE:
                return 11;
            default:
                return 0;
        }
    }

    // Override toString() method to provide a human-readable representation of the
    // card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}
