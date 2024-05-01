package org.advance.model;

import java.util.List;

public interface Deck {

    void shuffle();
    List<Card> getCards();
}
