package com.munchkin_app.model;

/**
 * User: boris
 * Date: 13.06.13
 * Time: 0:12
 */
public class Player {
    private final String name;
    private int level;

    public Player(String name) {
        this.name = name;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void incLevel() {
        this.level++;
    }

    public void decLevel() {
        if (this.level > 1)
            level--;
    }
}
