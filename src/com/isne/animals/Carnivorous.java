package com.isne.animals;

import com.isne.board.Board;

public class Carnivorous extends Animal {

    @Override
    protected boolean condition(Board board, int x, int y) {
        return false;
    }

    @Override
    protected boolean eat(Animal animal) {
        int randCarnivorous = (int) Math.floor(Math.random() * (10 + 1));
        int randHerbivorous = (int) Math.floor(Math.random() * (8 + 1));
        int carnivorousFightNumber = randCarnivorous * this.getStrength() / this.getStrength();
        int herbivorousFightNumber = randHerbivorous * animal.getStrength() / animal.getStrength();
        return carnivorousFightNumber > herbivorousFightNumber;
    }

}
