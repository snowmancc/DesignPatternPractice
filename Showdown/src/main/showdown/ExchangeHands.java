package main.showdown;

import java.util.List;

public class ExchangeHands {
    private boolean alreadyUse;
    private Player theOtherPlayer;
    private Player self;
    private int expiryTime;
    public static final int MAX_EXPIRY_TIME = 3;

    public ExchangeHands(Player self) {
        this.alreadyUse = false;
        this.expiryTime = 0;
        this.self =self;
    }

    public boolean canUse(){
        return !alreadyUse;
    }

    public void useSkill(Player theOtherPlayer){
        this.theOtherPlayer = theOtherPlayer;
        List<Card> selfHands = this.self.getHands();
        this.self.setHands(theOtherPlayer.getHands());
        theOtherPlayer.setHands(selfHands);
    }

    public void skillEffect(){
        this.theOtherPlayer = theOtherPlayer;
        List<Card> selfHands = this.self.getHands();
        this.self.setHands(theOtherPlayer.getHands());
        theOtherPlayer.setHands(selfHands);
    }

    public void increaseExpiryTime() {
        expiryTime++;
    }

    public boolean isTimeExpired() {
        return expiryTime == MAX_EXPIRY_TIME;
    }
}
