package main;

import main.cardGame.Deck;
import main.cardGame.Game;
import main.cardGame.uno.UnoCard;
import main.cardGame.uno.UnoGame;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
//        game.start(new BiggerGame(new Deck(Poke.createPokes())));
        game.start(new UnoGame(new Deck(UnoCard.createUnoCards())));
    }
}
