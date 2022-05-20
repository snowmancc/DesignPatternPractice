package main.showdown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Showdown {
    private static final int MAX_PLAYER = 4;
    private static final int MAX_Round = 13;
    private static final int WIN_POINTS = 1;
    private final Scanner input = new Scanner(System.in);
    private final List<Player> players;
    private final Deck deck;

    public Showdown() {
        this.players = new ArrayList<>(MAX_PLAYER);
        this.deck = new Deck();
    }

    public void start() {
        createPlayers();
        drawCards();
        int round = 0;
        while (round < MAX_Round) {
            round++;
            startNewRound(round);
        }
        showWinPlayer();
    }

    private void createPlayers() {
        System.out.print("請輸入參加人數(最多四人):");
        int humanPlayerAmount = input.nextInt();
        System.out.println("人類玩家數量:" + humanPlayerAmount);
        for (int i = 0; i < MAX_PLAYER; i++) {
            Player player = i < humanPlayerAmount ? new HumanPlayer(input): new AIPlayer();
            System.out.println("創建玩家-" + (i + 1));
            player.nameSelf();
            players.add(player);
        }
    }

    private void drawCards() {
        int piece = 0;
        while (!deck.isEmpty()) {
            Player player = players.get(piece++ % MAX_PLAYER);
            player.drawCard(deck.dealCard());
        }
    }

    private void startNewRound(int round) {
        System.out.println("回合:" + round);
        Card bigger = action(players.get(0));
        Player winner = players.get(0);

        for (int i = 1; i < MAX_PLAYER; i++) {
            Player player = players.get(i);
            System.out.println("輪到玩家-" + player.getName() + " 行動");
            Card card = action(player);
            if (card.compareTo(bigger) > 0) {
                bigger = card;
                winner = player;
            }
        }
        winner.addPoint(WIN_POINTS);
        System.out.println("玩家-" + winner.getName() + " 獲勝，獲得" + WIN_POINTS + "分");
        System.out.println("-----------------------");
    }

    private Card action(Player player) {
        player.showHand();
        player.useSkillIfCan(players);
        return player.showCard();
    }

    private void showWinPlayer() {
        Player winPlayer = players.get(0);
        for (Player player : players) {
            if (player.getPoints() > winPlayer.getPoints()) {
                winPlayer = player;
            }
        }
        System.out.println("Winner is " + winPlayer.getName() + " have " + winPlayer.getPoints() + " points");
    }
}
