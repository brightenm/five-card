package org.advance.utils;

import org.advance.model.Card;
import org.advance.model.Hand;
import org.advance.model.Rank;
import org.advance.model.Suit;

import java.util.List;

import static org.advance.utils.HandRankingType.*;

/**
 * A 5-Card hand typically has 5 cards from a deck of normal playing cards.
 * @author Nkanyiso Mthimkhulu
 */
public class FiveCardHandRanker implements HandRanker {

    /**
     * Calculate a score for this poker hand so it can be compared with others.
     * Takes into account the suit and rank when determining the score to break ties if 2 hands are the same.
     * Note that many systems do not differentiate based on suit. I do to prevent ties.
     * First do a coarse comparison based on the type of the hand. If a tie, then look more closely
     * @return score for the hand
     */
    @Override
    public HandRanking getHandRanking(Hand hand) {
        RankGrouping grouping = new RankGrouping(hand.getCards());
        List<Rank> ranks = grouping.getRanks();

        boolean hasStraight = hasStraight(ranks);
        boolean hasFlush = hasFlush(hand);

        HandRankingType type = getHandRankingType(grouping, hasStraight, hasFlush);

        return new HandRanking(type, ranks);
    }

    /**
     * @param grouping hand card grouping
     * @return the type of hand that we have. e.g. straight or flush
     */
    @Override
    public HandRankingType getHandRankingType(RankGrouping grouping, boolean hasStraight, boolean hasFlush) {
        if (grouping.matchesCounts(5)) return FIVE_OF_A_KIND;
        else if (hasStraight && hasFlush) return STRAIGHT_FLUSH;
        else if (grouping.matchesCounts(4, 1)) return FOUR_OF_A_KIND;
        else if (grouping.matchesCounts(3, 2)) return FULL_HOUSE;
        else if (hasFlush) return FLUSH;
        else if (hasStraight) return STRAIGHT;
        else if (grouping.matchesCounts(3, 1, 1)) return THREE_OF_A_KIND;
        else if (grouping.matchesCounts(2, 2, 1)) return TWO_PAIR;
        else if (grouping.matchesCounts(2, 1, 1, 1)) return PAIR;
        else return HIGH_CARD;
    }

    @Override
    public boolean hasFlush(Hand hand) {
        List<Card> cards = hand.getCards();
        Suit suit = cards.get(0).getSuit();

        for (Card card : cards) {
            if (card.getSuit() != suit) return false;
        }
        return true;
    }

    /**
     * Note the case of ace low needs to be considered.
     * @param ranks the cards ranks, ordered from high to low.
     * @return true if its a straight.
     */
    @Override
    public boolean hasStraight(List<Rank> ranks) {
        return ranks.size() == 5
                && (ranks.get(4) == Rank.ACE || (ranks.get(0).ordinal() - ranks.get(4).ordinal()) == 4);
    }
}
