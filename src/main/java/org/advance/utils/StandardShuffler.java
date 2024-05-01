package org.advance.utils;

import org.advance.model.Card;

import java.util.Collections;
import java.util.List;

public class StandardShuffler implements Shuffler {

    @Override
    public void shuffle(List<Card> cards) {

        System.out.println("Shuffling... Shuffling... Shuffling...");
        Collections.shuffle(cards);

    }
}
