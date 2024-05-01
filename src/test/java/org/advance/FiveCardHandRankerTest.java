package org.advance;

import org.advance.model.*;
import org.advance.utils.FiveCardHandRanker;
import org.advance.utils.HandRanking;
import org.advance.utils.HandRankingType;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FiveCardHandRankerTest {

    @Test
    public void HighCard() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "4♦", "6♣", "8♠", "7♠");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.HIGH_CARD, ranking.getHandRankingType());
    }

    @Test
    public void Pair() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "2♦", "6♣", "8♠", "7♠");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.PAIR, ranking.getHandRankingType());
    }

    @Test
    public void TwoPair() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "2♦", "6♣", "6♠", "7♠");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.TWO_PAIR, ranking.getHandRankingType());
    }

    @Test
    public void ThreeOfAKind() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "2♦", "2♣", "8♠", "7♠");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.THREE_OF_A_KIND, ranking.getHandRankingType());
    }

    @Test
    public void Straight() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "3♦", "4♣", "5♠", "6♠");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.STRAIGHT, ranking.getHandRankingType());
    }

    @Test
    public void Flush() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "4♥", "6♥", "8♥", "7♥");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.FLUSH, ranking.getHandRankingType());
    }

    @Test
    public void FullHouse() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "2♦", "2♣", "8♠", "8♠");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.FULL_HOUSE, ranking.getHandRankingType());
    }

    @Test
    public void FourOfAKind() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "2♦", "2♣", "2♠", "7♠");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.FOUR_OF_A_KIND, ranking.getHandRankingType());
    }

    @Test
    public void StraightFlush() {
        FiveCardHandRanker ranker = new FiveCardHandRanker();
        Hand hand = createHand("2♥", "3♥", "4♥", "5♥", "6♥");
        HandRanking ranking = ranker.getHandRanking(hand);
        assertEquals(HandRankingType.STRAIGHT_FLUSH, ranking.getHandRankingType());
    }

    private Hand createHand(String... cards) {
        List<Card> cardList = new ArrayList<>();
        for (String card : cards) {
            Rank rank = Rank.getRankForSymbol(card.substring(0, 1));
            Suit suit = Suit.getSuitForSymbol(card.substring(1));
            cardList.add(new Card(rank, suit));
        }
        return new FiveCardHand(cardList);
    }

}
