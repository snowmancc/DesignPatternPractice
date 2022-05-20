package main.cardGame.uno;

import main.cardGame.Card;

import java.util.Arrays;
import java.util.Stack;

public class UnoCard extends Card<UnoCard> {

    private final Color color;
    private final Number number;

    public UnoCard(Color color, Number number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public int compareTo(UnoCard o) {
        if (color == o.color || number == o.number) {
            return 1;
        } else {
            return -1;
        }
    }

    public static Stack<Card> createUnoCards() {
        Stack<Card> cards = new Stack<>();
        for (Color color : Color.values()) {
            for (Number number : Number.values()) {
                cards.add(new UnoCard(color, number));
            }
        }
        System.out.println("UNO__" + Arrays.toString(cards.toArray()));
        return cards;
    }

    @Override
    public String toString() {
        return color.toString() + "-" + number.toString();
    }
}
