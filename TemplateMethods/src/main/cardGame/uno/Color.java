package main.cardGame.uno;

public enum Color {
    BLUE("BLUE"),
    RED("RED"),
    YELLOW("YELLOW"),
    GREEN("GREEN");

    private final String symbol;

    Color(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
