package com.munch.domain;

/**
 * User: boris
 * Date: 08.06.13
 * Time: 22:21
 */
public class PlayerStats {
    private String name;
    private int gamesCount;
    private int winsCount;

    public PlayerStats(String name, boolean isWinner) {
        this.name = name;
        this.gamesCount = 1;
        this.winsCount = (isWinner) ? 1 : 0;
    }

    public PlayerStats(String name, int gamesCount, int winsCount) {
        this.name = name;
        this.gamesCount = gamesCount;
        this.winsCount = winsCount;
    }

    public void win() {
        this.gamesCount++;
        this.winsCount++;
    }

    public void lose() {
        this.gamesCount++;
    }

    public String getName() {
        return name;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public int getWinsCount() {
        return winsCount;
    }
}
