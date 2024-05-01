package org.advance.model;

import java.util.List;

public interface Hand {

    List<Card> getCards();
    void addCard(Card card);
}
