package main.cardGame.uno;

public enum Number {
    ONW("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    private final String value;

    Number(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
