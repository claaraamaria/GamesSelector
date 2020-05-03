package com.claramaria.gamesselector;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FactoryCardsInfoTest {
    @Test
    public void testUnu() {
        List<Data> games = FactoryCardsInfo.getCardsInfo(GameType.valueOfLabel("Ball Games"));
        assertEquals(4, games.size());
        assertEquals("Football (Soccer)", games.get(0).getImagePath());
    }

    @Test
    public void testDoi() {
        List<Data> games = FactoryCardsInfo.getCardsInfo(GameType.valueOfLabel("Drinking Games"));
        assertEquals(5, games.size());
        assertEquals("board_game", games.get(0).getImagePath());
    }
}

