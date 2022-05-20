package main.cardGame;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

public class HumanPlayer extends Player {

    private final Scanner input;

    public HumanPlayer(Scanner input) {
        this.input = input;
    }

    @Override
    public void nameSelf() {
        System.out.print("player's name: ");
        this.name = input.next();
        System.out.println("name is " + this.name);
    }

    @Override
    public Card showCard(CardGameTemplate gameTableInfo) {
        Card[] canShowCards = gameTableInfo.showCardsRule(hand.toArray(new Card[0]));
        if (0 == canShowCards.length) {
            System.out.println("No Card Can Show...");
            return null;
        }
        System.out.println("Your all hand: " + Arrays.toString(hand.toArray()));
        boolean canShow = false;
        int cardIndex = 0;
        while (!canShow) {
            System.out.println("Please choose one: " + Arrays.toString(canShowCards));
            cardIndex = input.nextInt();
            Card chooseCard = canShowCards[cardIndex];
            System.out.println("You choose the: " + chooseCard);
            for (Card canShowCard : canShowCards) {
                if (canShowCard.equals(chooseCard)) {
                    canShow = true;
                    cardIndex = hand.indexOf(chooseCard);
                    break;
                }
            }
            System.out.println("Can't Show this one: " + chooseCard);
        }
        return hand.remove(cardIndex);
    }
}
