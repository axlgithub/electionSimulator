package com.isne.animals;

import com.isne.board.Board;

public class Giraffe extends Herbivorous {
    public final String Symbol = " g ";

    public Giraffe() {
        this.setSpecies("Giraffe");
        this.setSymbol(Symbol);
        this.setSpeedOnGround(3);
        this.setWasStuckOnY(false);
    }

    public boolean condition(Board board, int x, int y) {
        return ((board.getCaseAt(x, y).getType() == "Bush") || (board.getCaseAt(x, y).getType() == "Tree"));
    }
}
