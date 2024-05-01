package org.advance;

import org.advance.model.*;
import org.advance.service.FiveCardGame;
import org.advance.service.Game;
import org.advance.utils.*;

public class FiveCardApp {
    public static void main(String[] args) {

        DeckInitializer deckInitializer = new StandardDeckInitializer();
        Deck deck = new NormalDeck(new StandardShuffler(), deckInitializer);

        // Create a dealer
        Dealer dealer = new StandardDealer();

        // Create a game with 5 cards in hand
        Game game = new FiveCardGame(deck, dealer, 5);

        // Start the game
        game.play();
    }
}