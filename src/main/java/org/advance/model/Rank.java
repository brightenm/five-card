package org.advance.model;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String name;
    private static final Map<String,Rank> RANK_FROM_SYMBOL = new HashMap<>();

    static {
        for (Rank r : values()) {
            RANK_FROM_SYMBOL.put(r.getName(), r);
        }
    }


    Rank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Rank getRankForSymbol(String symbol) {
        return RANK_FROM_SYMBOL.get(symbol);
    }
}
