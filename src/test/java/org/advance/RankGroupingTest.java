package org.advance;

import org.advance.model.Card;
import org.advance.model.Rank;
import org.advance.model.Suit;
import org.advance.utils.RankGrouping;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RankGroupingTest {

    @Test
    public void testGetRanks() {
        // Create a list of cards representing a hand
        List<Card> hand = Arrays.asList(
                new Card(Rank.TWO, Suit.SPADES),
                new Card(Rank.TWO, Suit.HEARTS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.DIAMONDS),
                new Card(Rank.FIVE, Suit.HEARTS)
        );

        // Create a RankGrouping object
        RankGrouping rankGrouping = new RankGrouping(hand);

        // Expected ranks after grouping
        List<Rank> expectedRanks = Arrays.asList(Rank.TWO, Rank.FIVE);

        // Assert that the expected ranks match the ranks returned by getRanks()
        assertEquals(expectedRanks, rankGrouping.getRanks());
    }

    @Test
    public void testMatchesCounts() {
        // Create a list of cards representing a hand
        List<Card> hand = Arrays.asList(
                new Card(Rank.TWO, Suit.SPADES),
                new Card(Rank.TWO, Suit.HEARTS),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.DIAMONDS),
                new Card(Rank.FIVE, Suit.HEARTS)
        );

        // Create a RankGrouping object
        RankGrouping rankGrouping = new RankGrouping(hand);

        // Test if the ranks match the specified counts
        // In this case, we expect matchesCounts to return true for counts [3, 2]
        boolean result = rankGrouping.matchesCounts(3, 2);

        // Assert that the result is true
        assertTrue(result);
    }
}
