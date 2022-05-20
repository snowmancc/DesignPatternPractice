package main.showdown;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {

    private static final int MAX_HAND_AMOUNT = 13;
    protected String name;
    private int points;
    protected List<Card> hand = new LinkedList<>();
    protected ExchangeHands exchangeHands;

    public Player() {
        this.exchangeHands = new ExchangeHands(this);
    }

    public abstract void nameSelf();

    public abstract Card showCard();

    public String getName() {
        return name;
    }

    public void addPoint(int point) {
        this.points += point;
    }

    public int getPoints() {
        return points;
    }

    public void drawCard(Card card) {
        this.hand.add(card);
    }

    public List<Card> getHands() {
        return hand;
    }

    public void setHands(List<Card> hands) {
        this.hand = hands;
    }

    public void useSkillIfCan(List<Player> players) {
        if (exchangeHands.canUse()) {
            System.out.println("是否要指定玩家換手排:");
            if (decideUseSkill()) {
                System.out.println("請選擇玩家:");
                Player otherPlayer = decidePlayer(players);
                exchangeHands.useSkill(otherPlayer);
                showHand();
            }
        } else {
            skillEffect();
        }
    }

    public abstract boolean decideUseSkill();

    public abstract Player decidePlayer(List<Player> players);

    public abstract void showHand();

    public void skillEffect() {
        if (exchangeHands.isTimeExpired()) {
            exchangeHands.skillEffect();
            showHand();
        } else {
            exchangeHands.increaseExpiryTime();
        }
    }
}
