package com.isne.animals;

import com.isne.board.Board;

public class Hippopotamus extends Herbivorous {
    public final String Symbol = " h ";

    public Hippopotamus() {
        this.setSpecies("Hippopotamus");
        this.setSymbol(Symbol);
        this.setSpeedOnGround(2);
        this.setWasStuckOnY(false);
    }

    public boolean condition(Board board, int x, int y) {
        return (board.getCaseAt(x, y).getType() == "Bush");
    }

}
