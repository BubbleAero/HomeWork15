package ru.netology;

import lombok.Getter;

public class Player {
    protected int id;
    @Getter
    protected String name;
    @Getter
    protected int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

}