package org.advance;

import org.advance.model.Card;
import org.advance.model.Deck;
import org.advance.model.NormalDeck;
import org.advance.utils.Shuffler;
import org.advance.utils.StandardDeckInitializer;
import org.advance.utils.StandardShuffler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class ShufflerTest {

    @Test
    public void testShuffle() {
        // Create a shuffler object
        Shuffler shuffler = new StandardShuffler();

        // Create a list of cards before shuffling
        Deck deck = new NormalDeck(new StandardShuffler(), new StandardDeckInitializer());
        List<Card> beforeShuffle = deck.getCards();

        // Create a copy of the list before shuffling
        List<Card> copyBeforeShuffle = new ArrayList<>(beforeShuffle);

        // Shuffle the list of cards
        shuffler.shuffle(beforeShuffle);

        // Assert that the shuffled list is not equal to the original list
        assertNotEquals(copyBeforeShuffle, beforeShuffle);
    }
}
