package main.cardGame;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    public Deck(Stack<Card> cards) {
        this.cards = cards;
    }

    public Card dealCard() {
        return cards.pop();
    }

    public void pushCard(Card card) {
        cards.push(card);
    }

    public Stack<Card> getCards(){
        return cards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public static void shuffle(Deck deck) {
        Collections.shuffle(deck.cards);
    }
}
