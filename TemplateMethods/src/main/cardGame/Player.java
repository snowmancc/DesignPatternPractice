package main.cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Player {

    private long id;
    protected String name;
    protected List<Card> hand;

    public Player() {
        this.id = System.currentTimeMillis();
        this.hand = new ArrayList<>();
    }

    public abstract void nameSelf();

    public abstract Card showCard(CardGameTemplate gameTableInfo);

    public void drawCard(Card card) {
        this.hand.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return this.name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
