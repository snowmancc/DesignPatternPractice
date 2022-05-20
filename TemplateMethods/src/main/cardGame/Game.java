package main.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final int MAX_PLAYER = 4;
    private final Scanner input = new Scanner(System.in);

    public void start(CardGameTemplate game) {
        List<Player> players = new ArrayList<>();
        byNameSelf(players);

        Player winner = game.runUntilHaveWinner(players);

        System.out.println("winner is : " + winner);
    }

    private void byNameSelf(List<Player> players) {
        System.out.print("請輸入參加人數(最多四人):");
        int humanPlayerAmount = input.nextInt();
        System.out.println("人類玩家數量:" + humanPlayerAmount);
        for (int i = 0; i < MAX_PLAYER; i++) {
            Player player = i < humanPlayerAmount ? new HumanPlayer(input) : new AIPlayer();
            System.out.println("創建玩家-" + (i + 1));
            player.nameSelf();
            players.add(player);
        }
    }
}
