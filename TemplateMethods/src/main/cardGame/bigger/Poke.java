package main.cardGame.bigger;

import main.cardGame.Card;

import java.util.Arrays;
import java.util.Stack;

public class Poke extends Card<Poke> {

    private final Suit suit;
    private final Rank rank;

    public Poke(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return suit.toString() + rank.toString();
    }

    @Override
    public int compareTo(Poke o) {
        if (rank == o.rank) {
            return suit.compareTo(o.suit);
        }
        return rank.compareTo(o.rank);
    }

    public static Stack<Card> createPokes() {
        Stack<Card> cards = new Stack<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Poke(suit, rank));
            }
        }
        System.out.println("POKE__" + Arrays.toString(cards.toArray()));
        return cards;
    }
}
