package main.showdown;

public enum Suit {
    CLUB("♣"),
    DIAMOND("♦"),
    HEART("♥"),
    SPADE("♠");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
