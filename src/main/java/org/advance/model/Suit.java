package org.advance.model;

public enum Suit {
    SPADES("♠"), HEARTS("♥"), CLUBS("♣"), DIAMONDS("♦");    // enum constants

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Suit getSuitForSymbol(String symbol) {
        switch (symbol) {
            case "♠":
                return SPADES;
            case "♥":
                return HEARTS;
            case "♣":
                return CLUBS;
            case "♦":
                return DIAMONDS;
            default:
                return null;
        }
    }
}
