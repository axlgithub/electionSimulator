package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Case;

public class Hippopotamus extends Herbivorous {
    public final String Symbol = " h ";

    public Hippopotamus() {
        this.setSpecies("Hippopotamus");
        this.setSymbol(Symbol);
        this.setSpeedOnGround(2);
    }

    public boolean condition(Board board, int x, int y) {
        return (board.getCaseAt(x, y).getType() == "Bush");
    }

    @Override
    public Case nearestPlant() {
        Case superCase = new Case();
        return (superCase);
    }
}
