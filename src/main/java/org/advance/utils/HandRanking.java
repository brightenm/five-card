package org.advance.utils;

import org.advance.model.Rank;

import java.util.List;

public class HandRanking {

    private HandRankingType handRankingType;
    private List<Rank> handRanks;

    /**
     * Constructor
     * @param handRankingType the type of 5-card hand. This is the most important factor.
     * @param handRanks the unique card ranks in order of importance. This the secondary factor used to
     *              break ties between hands of the same type - although ties can still occur.
     *              "In order of importance" means the ranks are sorted by how they match up with the type of hand.
     *              For example, the ranks list for a full house like "4D 4H 4C QS QD" will be (4, Q) because the
     *              4 is more important that the queen because there are 3 of them.
     */
    public HandRanking(HandRankingType handRankingType, List<Rank> handRanks) {
        this.handRankingType = handRankingType;
        this.handRanks = handRanks;

    }

    public HandRankingType getHandRankingType() {
        return handRankingType;
    }

    public List<Rank> getRanks() {
        return handRanks;
    }
}
