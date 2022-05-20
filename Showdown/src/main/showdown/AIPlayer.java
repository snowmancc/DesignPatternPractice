package main.showdown;

import java.util.List;

public class AIPlayer extends Player{

    @Override
    public void nameSelf() {
        this.name = "AII";
    }

    @Override
    public Card showCard() {
        return null;
    }

    @Override
    public boolean decideUseSkill() {
        return false;
    }

    @Override
    public Player decidePlayer(List<Player> players) {
        return null;
    }

    @Override
    public void showHand() {

    }
}
