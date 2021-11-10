package com.isne.animals;

import com.isne.board.Board;

public class Herbivorous extends Animal {

    @Override
    protected boolean condition(Board board, int x, int y) {
        return true;
    }


}
