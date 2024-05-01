package org.advance.model;

import java.io.Serializable;

/**
 * Represents a standard playing card.
 */
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Rank value;
    private final Suit suit;

    public Card(Rank value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Create a card instance from a string
     * @param cardToken string representation of the card (e.g. "JD", or "10H")
     */
    public Card(String cardToken) {
        int len = cardToken.length();
        assert (len < 4);

        this.value = Rank.getRankForSymbol(cardToken.substring(0, len-1));
        this.suit = Suit.getSuitForSymbol(cardToken.substring(len-1));
    }

    public Rank getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", value, suit);
    }
}
