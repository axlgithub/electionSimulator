package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Case;

public class Carnivorous extends Animal {
    public void move() {
        this.setHunger(5);
    }

    @Override
    protected boolean condition(Board board, int x, int y) {
        return false;
    }

    // attack an animal
    public boolean fight(Animal animal) {
        int randCarnivorous = (int) Math.floor(Math.random()*(10+1));
        int randHerbivorous = (int) Math.floor(Math.random()*(8+1));
        int carnivorousFightNumber = randCarnivorous * this.getStrength() / this.getStrength();
        int herbivorousFightNumber = randHerbivorous * animal.getStrength() / animal.getStrength();
        return carnivorousFightNumber > herbivorousFightNumber;
    }

    public Case nearestPrey() {
        Case superCase = new Case();
        return (superCase);
    }

}
