package org.advance.model;

import org.advance.utils.DeckInitializer;
import org.advance.utils.Shuffler;
import org.advance.utils.StandardDeckInitializer;
import org.advance.utils.StandardShuffler;

import java.util.List;

/**
 * Represents a standard deck of playing cards without jokers, initialized and shuffled.
 * @see StandardDeckInitializer
 * @see StandardShuffler
 * @author Nkanyiso Mthimkhulu
 */
public class NormalDeck implements Deck {

    private final List<Card> cards;
    private final Shuffler shuffler;

    public NormalDeck(Shuffler shuffler, DeckInitializer deckInitializer) {
        this.cards = deckInitializer.initializeDeck();
        this.shuffler = shuffler;
    }

    @Override
    public void shuffle() {
        shuffler.shuffle(this.cards);
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

}
