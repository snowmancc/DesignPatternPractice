package main.cardGame;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import static main.cardGame.Game.MAX_PLAYER;


public abstract class CardGameTemplate {

    protected Deck deck;
    protected List<Player> players;


    public CardGameTemplate(Deck deck) {
        if (deck == null || deck.isEmpty()) throw new EmptyStackException();
        this.deck = deck;
    }

    public Player runUntilHaveWinner(List<Player> players) {
        if (players.size() != 4) throw new RuntimeException();// TODO EXCEPTION
        this.players = players;
        prepare();
        Deck.shuffle(deck);
        drawCards();
        while (!isGameFinish()) {
            takeATurn();
        }
        return getWinner();
    }

    protected abstract void prepare();

    private void drawCards() {
        int piece = MAX_PLAYER * initialPiece();
        System.out.println("piece----" + piece);
        for (int i = 0; i < piece; i++) {
            Player player = players.get(i % MAX_PLAYER);
            Card card = deck.dealCard();
            player.drawCard(card);
        }
        System.out.println("HHHHHHHHHHAND======");
        System.out.println(Arrays.toString(players.get(0).hand.toArray()));
        System.out.println(Arrays.toString(players.get(1).hand.toArray()));
        System.out.println(Arrays.toString(players.get(2).hand.toArray()));
        System.out.println(Arrays.toString(players.get(3).hand.toArray()));
        System.out.println("HHHHHHHHHHAND======");
    }

    protected abstract int initialPiece();

    protected abstract boolean isGameFinish();

    protected abstract void takeATurn();

    protected abstract Player getWinner();

    public Card[] showCardsRule(Card[] hand) {
        return hand;
    }
}
