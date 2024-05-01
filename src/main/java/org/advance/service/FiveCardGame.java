package org.advance.service;


import org.advance.model.*;
import org.advance.utils.Dealer;
import org.advance.utils.FiveCardHandRanker;
import org.advance.utils.HandRanker;
import org.advance.utils.HandRanking;

import java.util.List;

/**
 * Represents a game of five-card poker.
 * Deals a hand from a deck, evaluates the hand, and prints the result.
 *
 * @author Nkanyiso Mthimkhulu
 *
 */
public class FiveCardGame implements Game {

    private final Deck deck;
    private final Dealer dealer;
    private final int numberOfCardsInHand;

    /**
     * Constructs a new FiveCardGame instance.
     *
     * @param deck                The deck of cards to use in the game.
     * @param dealer              The dealer responsible for dealing cards.
     * @param numberOfCardsInHand The number of cards to deal for each hand.
     */
    public FiveCardGame(Deck deck, Dealer dealer, int numberOfCardsInHand) {
        this.deck = deck;
        this.dealer = dealer;
        this.numberOfCardsInHand = numberOfCardsInHand;
    }

    /**
     * Plays a game of five-card poker.
     * - Shuffles the deck.
     * - Deals a hand.
     * - Evaluates the hand and prints the result.
     */
    @Override
    public void play() {

        try{
        // Shuffle the deck
        deck.shuffle();

        // Deal a hand
        Hand hand = dealer.dealHand(deck, numberOfCardsInHand);
        List<Card> cards = hand.getCards();

        // Evaluate the hand and determine the result
        HandRanker handRanker = new FiveCardHandRanker();
        HandRanking handRanking = handRanker.getHandRanking(hand);

        // Print the player's hand
        StringBuilder handString = new StringBuilder("Your hand: ");
        for (Card card : cards) {
            String rankSymbol = card.getValue().getName();
            String suitSymbol = card.getSuit().getName();

            handString.append(rankSymbol).append(suitSymbol).append(" ");
        }
        System.out.println(handString.toString());

        // Print the hand ranking
        System.out.println("You have: " + handRanking.getHandRankingType().toString());

        }catch(Exception e){
            System.err.println("An error occurred while playing the game: " + e.getMessage());
        }

    }
}
