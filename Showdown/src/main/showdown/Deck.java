package main.showdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    public Deck() {
        cards = createStandardDeck();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    private Stack<Card> createStandardDeck() {
        Stack<Card> cards = new Stack<>();
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }
}
