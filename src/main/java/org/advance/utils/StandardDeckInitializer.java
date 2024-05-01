package org.advance.utils;

import org.advance.model.Card;
import org.advance.model.Rank;
import org.advance.model.Suit;

import java.util.ArrayList;
import java.util.List;

public class StandardDeckInitializer implements DeckInitializer {

    @Override
    public List<Card> initializeDeck() {
        List<Card> cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        return cards;
    }
}
