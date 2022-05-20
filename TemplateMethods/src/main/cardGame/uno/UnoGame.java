package main.cardGame.uno;

import main.cardGame.Card;
import main.cardGame.CardGameTemplate;
import main.cardGame.Deck;
import main.cardGame.Player;

import java.util.Arrays;
import java.util.Stack;

import static main.cardGame.Game.MAX_PLAYER;

public class UnoGame extends CardGameTemplate {

    private static final int INITIAL_PIECE = 5;

    private Deck table;

    private Card lastCard;

    private Player actor;

    public UnoGame(Deck deck) {
        super(deck);
    }

    @Override
    protected void prepare() {
        // TODO first card
        lastCard = deck.dealCard();
        table = new Deck(new Stack<>());
    }

    @Override
    protected int initialPiece() {
        return INITIAL_PIECE;
    }

    @Override
    protected boolean isGameFinish() {
        return actor != null && actor.getHand().isEmpty();
    }

    @Override
    protected void takeATurn() {
        for (int i = 0; i < MAX_PLAYER; i++) {
            Player player = players.get(i);
            System.out.println("Player " + player.getName() + " your turn ~");
            System.out.println("Last card is " + lastCard);
            Card showPoke = player.showCard(this);
            if (showPoke == null) {
                if (deck.isEmpty()) {
                    reDeck();
                }
                player.drawCard(deck.dealCard());
            } else {
                table.pushCard(lastCard);
                lastCard = showPoke;
            }
        }
    }

    private void reDeck() {
        if (!deck.isEmpty()) throw new RuntimeException("reDeck error");// TODO
        deck = new Deck(table.getCards());
    }

    @Override
    protected Player getWinner() {
        return actor;
    }

    @Override
    public Card[] showCardsRule(Card[] hand) {
        return Arrays.stream(hand).filter(card -> lastCard.equals(card)).toArray(Card[]::new);
    }
}
