package org.advance.utils;

/**
 * Types of poker hands. For example, royal flush, straight, full house, three of a kind, etc.
 * @author Nkanyiso Mthimkhulu
 */
public enum HandRankingType {

    // note: five of a kind can only happen if using wild cards
    HIGH_CARD("High Card", 1),
    PAIR("Pair", 1.37f),
    TWO_PAIR("Two Pair", 20),
    THREE_OF_A_KIND("Three of a Kind", 40),
    STRAIGHT("Straight", 254),
    FLUSH("Flush", 508),
    FULL_HOUSE("Full House", 693),
    FOUR_OF_A_KIND("Four of a Kind", 4164),
    STRAIGHT_FLUSH("Straight Flush", 72192),
    ROYAL_FLUSH("Royal Flush", 649740),
    FIVE_OF_A_KIND("Five of a Kind", 749740);

    /** Descriptive name for the type of hand */
    private final String label;

    /** occurs one in this many hands  */
    private final float odds;

    HandRankingType(String label, float odds) {
        this.label = label;
        this.odds = odds;
    }

    public String label()   { return label; }

    public float odds() { return odds; }

    public String toString() {
        return label;
    }

}
