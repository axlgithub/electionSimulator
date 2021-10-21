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
        System.out.println(animal.getHunger());
        return true;
    }

    public Case nearestPrey() {
        Case superCase = new Case();
        return (superCase);
    }

}
