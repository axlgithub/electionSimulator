package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Plant;

public class Herbivorous extends Animal {

    @Override
    protected boolean condition(Board board, int x, int y) {
        return true;
    }

    public void eat(Plant plant) {
        System.out.println("super ! ");
    }

}
