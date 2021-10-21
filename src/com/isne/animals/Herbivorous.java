package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Case;
import com.isne.board.Plant;

public class Herbivorous extends Animal {
    public void move() {
        this.setHunger(5);
    }

    @Override
    protected boolean condition(Board board, int x, int y) {
        return true;
    }

    public void eat(Plant plant) {
        System.out.println("super ! ");
    }

    public Case nearestPlant() {
        Case superCase = new Case();
        return (superCase);
    }
}
