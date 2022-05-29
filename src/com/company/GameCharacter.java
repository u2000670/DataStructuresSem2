package com.company;

import java.util.Comparator;
import java.util.Objects;

public class GameCharacter{

    private String name;
    private int height;
    private int weight;
    private int strength;
    private int agility;
    private int intelligence;
    private int coordination;
    private int leadership;

    public GameCharacter(String name, int height, int weight, int strength, int agility, int intelligence, int coordination, int leadership) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.coordination = coordination;
        this.leadership = leadership;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCoordination() {
        return coordination;
    }

    public int getLeadership() {
        return leadership;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nHeight: " + height + "cm" + "\nWeight: " + weight + "kg" +
                "\nStrength: " + strength + "\nAgility: " + agility + "\nIntelligence: " + intelligence +
                "\nCoordination: " + coordination + "\nLeadership: " + leadership + "\n";
    }


    //equalling it to strength only atm
    @Override
    public boolean equals(Object obj) {
        GameCharacter gc = (GameCharacter) obj;
        return Objects.equals(this.name, gc.name);
    }

}
