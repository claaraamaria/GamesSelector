package com.claramaria.ludsim.model;

import java.util.HashMap;
import java.util.Map;

public enum GameType {
    BALL_GAMES("Ball Games"),
    BOARD_GAMES("Board Games"),
    DRINKING_GAMES("Drinking Games"),
    CARD_GAMES("Card Games"),
    INTERACTIVE_GAMES("Interactive Games");

    private final String label;
    private static final Map<String, GameType> BY_LABEL = new HashMap<>();
    static {
        for (GameType e: values()) {
            BY_LABEL.put(e.label, e);
        }
    }
    GameType(String label) {
        this.label = label;

    }
    public static GameType valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
