package com.isne.animals;

public abstract class Animal {
    private int life;
    private int strength;
    private int hunger;
    private int speedOnGround;
    private int speedOnWatter;
    private int id;
    private boolean canSwim;
    private String species;

    public abstract void move();

    /* Getters and setters   */

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getSpeedOnGround() {
        return speedOnGround;
    }

    public void setSpeedOnGround(int speedOnGround) {
        this.speedOnGround = speedOnGround;
    }

    public int getSpeedOnWatter() {
        return speedOnWatter;
    }

    public void setSpeedOnWatter(int speedOnWatter) {
        this.speedOnWatter = speedOnWatter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
