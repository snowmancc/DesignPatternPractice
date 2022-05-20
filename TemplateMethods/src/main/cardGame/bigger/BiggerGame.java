package main.cardGame.bigger;

import main.cardGame.Card;
import main.cardGame.CardGameTemplate;
import main.cardGame.Deck;
import main.cardGame.Player;

import java.util.*;
import java.util.Map.Entry;

import static main.cardGame.Game.MAX_PLAYER;

public class BiggerGame extends CardGameTemplate {

    private static final int INITIAL_PIECE = 13;
    private static final int MIX_ROUND = 13;
    private int roundCount;

    private Map<Player, Integer> playerOrderAndScore;

    public BiggerGame(Deck deck) {
        super(deck);
    }

    @Override
    protected void prepare() {
        playerOrderAndScore = new HashMap<>();
        players.forEach(player -> playerOrderAndScore.put(player, 0));
    }

    @Override
    protected int initialPiece() {
        return INITIAL_PIECE;
    }

    @Override
    protected boolean isGameFinish() {
        return MIX_ROUND == roundCount;
    }

    @Override
    protected void takeATurn() {
        // TODO Game
        Map<Player, Card> tableCards = new HashMap<>();
        for (int i = 0; i < MAX_PLAYER; i++) {
            Player player = players.get(i);
            System.out.println("Player " + player.getName() + " your turn ~");
            Card showPoke = player.showCard(this);
            tableCards.put(player, showPoke);
        }

        List<Entry<Player, Card>> playersCard = new ArrayList<>(tableCards.entrySet());
        System.out.println("Display Cards");
        playersCard.forEach(playerCardEntry -> System.out.println(playerCardEntry.getKey() + " show:" + playerCardEntry.getValue()));

        playersCard.sort(Entry.comparingByValue());
        Player getTurnPlayer = playersCard.get(MAX_PLAYER - 1).getKey();
        System.out.println("Get Turn Player is " + getTurnPlayer);
        int score = playerOrderAndScore.get(getTurnPlayer);
        playerOrderAndScore.put(getTurnPlayer, ++score);
        playerOrderAndScore.forEach((p, s) -> System.out.println(p.getName() + "'s Score is: " + s));
        roundCount++;
    }

    @Override
    protected Player getWinner() {
        List<Entry<Player, Integer>> playersScore = new ArrayList<>(playerOrderAndScore.entrySet());
        playersScore.sort(Entry.comparingByValue());
        return playersScore.get(MAX_PLAYER - 1).getKey();
    }

    @Override
    public Card[] showCardsRule(Card[] hand) {
        return hand;
    }
}
