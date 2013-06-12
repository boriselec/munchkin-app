package com.munch.model;

import com.munch.domain.BadPlayerException;
import com.munch.domain.PlayerStats;

import java.util.List;

/**
 * User: boris
 * Date: 08.06.13
 * Time: 20:50
 */
public interface Model {
    void newGame();

    void addPlayer(String name) throws BadPlayerException;

    void removePlayer(String name) throws BadPlayerException;

    void incLevel(String player) throws BadPlayerException;

    void decLevel(String player) throws BadPlayerException;

    void closeGame();

    List<PlayerStats> getStats();

    List<String> getLastPlayers();
}
