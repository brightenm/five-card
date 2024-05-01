package org.advance.utils;

import org.advance.model.Card;
import org.advance.model.Rank;

import java.util.*;

import static org.advance.model.Rank.*;

/**
 * Analyzes a 5-Card hand and creates a map which has an entry for each card rank represented
 * in the hand and its associated count. Given that information its easy to determine things like
 * how many of a certain rank there is. Immutable.
 *
 * @author Nkanyiso Mthimkhulu
 */
public class RankGrouping {

    private List<RankGroup> groups;

    /** the one case where ace is treated as low instead of high in poker */
    private static final List<Rank> ACE_LOW_STRAIGHT = Arrays.asList(ACE, FIVE, FOUR, THREE, TWO);

    public RankGrouping(List<Card> hand) {
        groups = init (hand);
    }

    /**
     * Used to differentiate between hands of the same type - like two full house hands
     * or two hands that are both three of a kind.
     * There is one special case to be aware of however.
     * If the ranks are A, 5, 4, 3, 2, then A is low and 5, 4, 3, 2, A is returned.
     */
    public List<Rank> getRanks() {

        List<Rank> ranks = new ArrayList<>();
        for (RankGroup group : groups) {
            ranks.add(group.rank);
        }
        if (ranks.equals(ACE_LOW_STRAIGHT)) {
            ranks.remove(0);
            ranks.add(ACE);
        }
        return ranks;
    }

    /**
     * Match against a specific list of counts which will map to a specific hand type.
     * For example, [3, 2] maps to a full house
     * [4, 1] maps to a four of a kind
     * [3, 1, 1] maps to three of a kind, etc
     * @param counts list of counts to match against.
     * @return true if matches the specified list of counts.
     */
    public boolean matchesCounts(int... counts) {

        if (groups.size() != counts.length) return false;

        for (int i=0; i<counts.length; i++)
        {
            if (counts[i] != groups.get(i).count) {
                return false;
            }
        }

        return true;
    }

    /**
     * Builds the map which has an entry for each card rank represented in the hand and its associated count.
     * Assumes that the cards in the hands are sorted descending by rank.
     */
    private List<RankGroup> init(List<Card> hand) {

        Map<Rank, RankGroup> map = new HashMap<>();
        try {

            for (Card card : hand) {
                RankGroup group = map.get(card.getValue());
                if (group != null) {
                    group.count++;
                } else {
                    map.put(card.getValue(), new RankGroup(card.getValue(), 1));
                }

            }

            List<RankGroup> groups = new ArrayList<>(map.values());
            Collections.sort(groups);
            return groups;
        }catch (Exception e) {
            throw new IllegalArgumentException("Invalid hand", e);
        }
    }

    private static class RankGroup implements Comparable<RankGroup> {

        int count;
        public Rank rank;

        RankGroup(Rank rank, int count) {
            this.rank = rank;
            this.count = count;
        }

        @Override
        public int compareTo(RankGroup group) {
            if (group == null) {
                throw new NullPointerException("Cannot compare with a null RankGroup");
            }
            if (group.count == this.count) {
                return group.rank.ordinal() - this.rank.ordinal();
            }
            return group.count - this.count;
        }
    }
}
