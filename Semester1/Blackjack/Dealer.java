package Semester1.Blackjack;

public class Dealer extends Player { // Dealer is a subclass of PLayer

    public Dealer(int balance) {
        super(balance);
    }

    public void play(Card card) {
        while (getHandValue() < 17) {
            addCard(card);
        }
    }
}
