package org.advance.utils;

import org.advance.model.Card;
import org.advance.model.Deck;
import org.advance.model.FiveCardHand;
import org.advance.model.Hand;

import java.util.ArrayList;
import java.util.List;

public class StandardDealer implements Dealer{
    @Override
    public Hand dealHand(Deck deck, int numberOfCards) {
        Hand hand = new FiveCardHand(new ArrayList<>());
        List<Card> cards = deck.getCards();
        for (int i = 0; i < numberOfCards; i++ ){
            //addCard to the hand object but removed from the deck
            hand.addCard(cards.remove(0));
        }
        return hand;
    }
}
