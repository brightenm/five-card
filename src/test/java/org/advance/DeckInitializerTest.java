package org.advance;

import org.advance.model.Card;
import org.advance.utils.DeckInitializer;
import org.advance.utils.StandardDeckInitializer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeckInitializerTest {

    @Test
    public void testInitializeDeck() {
        // Create a deck initializer object
        DeckInitializer deckInitializer = new StandardDeckInitializer();

        // Initialize a deck
        List<Card> cards = deckInitializer.initializeDeck();

        // Assert that the deck contains the expected number of cards
        assertEquals(52, cards.size());
    }
}
