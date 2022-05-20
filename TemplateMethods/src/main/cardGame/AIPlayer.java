package main.cardGame;

import java.util.Arrays;
import java.util.Random;

public class AIPlayer extends Player {

    private final Random random = new Random();

    @Override
    public void nameSelf() {
        String str = "abcdefghigklmnopkrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int number = random.nextInt(62);//0~61
            sf.append(str.charAt(number));
        }
        this.name = sf.toString();
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
            cardIndex = random.nextInt(canShowCards.length);
            Card chooseCard = canShowCards[cardIndex];
            System.out.println("You choose the: " + chooseCard);
            for (Card canShowCard : canShowCards) {
                if (canShowCard.equals(chooseCard)) {
                    canShow = true;
                    cardIndex = hand.indexOf(chooseCard);
                    break;
                }
                System.out.println("Can't Show this one: " + chooseCard);
            }
        }
        return hand.remove(cardIndex);
    }
}
