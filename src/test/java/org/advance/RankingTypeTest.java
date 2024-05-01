package org.advance;

import org.advance.model.Rank;
import org.advance.utils.HandRanking;
import org.advance.utils.HandRankingType;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RankingTypeTest {

    @Test
    public void testHandRankingType() {
        List<Rank> ranks = Arrays.asList(Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX);
        HandRanking ranking = new HandRanking(HandRankingType.STRAIGHT, ranks);
        assertEquals(HandRankingType.STRAIGHT, ranking.getHandRankingType());
    }

    @Test
    public void testHandRanks() {
        List<Rank> ranks = Arrays.asList(Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX);
        HandRanking ranking = new HandRanking(HandRankingType.STRAIGHT, ranks);
        assertEquals(ranks, ranking.getRanks());
    }
}
