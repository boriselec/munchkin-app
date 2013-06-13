package com.munchkin_app.model;

import com.munchkin_app.domain.BadPlayerException;
import com.munchkin_app.domain.PlayerStats;

import java.util.LinkedList;
import java.util.List;

/**
 * User: boris
 * Date: 08.06.13
 * Time: 20:48
 */
public class Game implements Model {
    private final static int MAX_PLAYERS = 6;
    private final static int WINNING_LEVEL = 10;

    private boolean isRunning = false;
    List<PlayerStats> playersStats;
    List<Player> players;
    List<String> history;


    @Override
    public void newGame() {
        playersStats = new LinkedList<PlayerStats>();
        players = new LinkedList<Player>();
        history = new LinkedList<String>();
        isRunning = true;
    }

    @Override
    public void addPlayer(String name) throws BadPlayerException {
        if (!isRunning)
            throw new BadPlayerException("Game is not running");
        if (players.size() >= MAX_PLAYERS)
            throw new BadPlayerException("Game is full");
        if (isPlayerInGame(name))
            throw new BadPlayerException("Player already in game");

        players.add(new Player(name));
    }

    @Override
    public void removePlayer(String name) throws BadPlayerException {
        if (!isRunning)
            throw new BadPlayerException("Game is not running");
        if (!isPlayerInGame(name))
            throw new BadPlayerException("Player not in game");

        for (Player player : players)
            if (player.getName().equals(name))
                players.remove(player);

    }

    @Override
    public void incLevel(String playerName) throws BadPlayerException {
        if (!isRunning)
            throw new BadPlayerException("Game is not running");
        if (!isPlayerInGame(playerName))
            throw new BadPlayerException("Player not in game");

        for (Player player : players) {
            if (player.getName().equals(playerName))
                player.incLevel();
            if (player.getLevel() >= WINNING_LEVEL) {
                isRunning = false;
                //TODO: notify
            }
        }
    }


    @Override
    public void decLevel(String playerName) throws BadPlayerException {
        if (!isRunning)
            throw new BadPlayerException("Game is not running");
        if (!isPlayerInGame(playerName))
            throw new BadPlayerException("Player not in game");

        for (Player player : players)
            if (player.getName().equals(playerName))
                player.decLevel();
    }

    @Override
    public void closeGame() {
        isRunning = false;
    }

    @Override
    public List<PlayerStats> getStats() {
        return this.playersStats;
    }

    //TODO: make order
    @Override
    public List<String> getLastPlayers() {
        List<String> result = new LinkedList<String>();
        for (PlayerStats player : playersStats)
            result.add(player.getName());
        return result;
    }

    private boolean isPlayerInGame(String playerName) {
        for (Player inGamePlayer : players)
            if (inGamePlayer.getName().equals(playerName))
                return true;
        //not found
        return false;
    }
}
