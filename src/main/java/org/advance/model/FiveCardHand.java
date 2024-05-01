package org.advance.model;

import java.util.List;

/**
 * A 5-Card hand typically has 5 cards from a deck of normal playing cards.
 * @author Nkanyiso Mthimkhulu
 */
public class FiveCardHand implements Hand {

    private final List<Card> cards;

    public FiveCardHand(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }
}
