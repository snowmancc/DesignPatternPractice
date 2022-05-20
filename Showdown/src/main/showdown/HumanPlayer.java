package main.showdown;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner input;

    public HumanPlayer(Scanner input) {
        this.input = input;
    }

    @Override
    public void nameSelf() {
        System.out.print("player's name: ");
        this.name = input.next();
        System.out.print("name is " + this.name);
    }

    @Override
    public Card showCard() {
        System.out.println("Please choose a card: ");
        int cardIndex = input.nextInt();
        return hand.remove(cardIndex);
    }

    @Override
    public boolean decideUseSkill() {
        System.out.println("是否是用技能Y/N: ");
        return "Y".equals(input.next());
    }

    @Override
    public Player decidePlayer(List<Player> players) {
        while (true) {
            System.out.println("選擇玩家 1-4:");
            int index = input.nextInt();
            Player otherPlayer = players.get(index);
            if (this != otherPlayer) {
                return otherPlayer;
            }
        }
    }

    @Override
    public void showHand() {
        for (int i = 0; i < hand.size(); i++) {
            String delimiter = i == hand.size() - 1 ? "\n" : ", ";
            System.out.print("(" + i + ") " + hand.get(i) + delimiter);
        }
    }
}
