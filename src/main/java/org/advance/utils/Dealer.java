package org.advance.utils;

import org.advance.model.Deck;
import org.advance.model.Hand;

public interface Dealer {
    Hand dealHand(Deck deck, int numberOfCards);
}
