package org.advance.utils;


import org.advance.model.Hand;
import org.advance.model.Rank;

import java.util.List;

public interface HandRanker {
    HandRanking getHandRanking(Hand hand);

    HandRankingType getHandRankingType(RankGrouping grouping, boolean hasStraight, boolean hasFlush);

    boolean hasFlush(Hand hand);

    boolean hasStraight(List<Rank> ranks);

}
