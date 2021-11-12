package com.isne.animals;

import com.isne.board.Board;

public class Giraffe extends Herbivorous {
    public final String Symbol = " g ";
    public static int giraffeHunger = 10;

    public Giraffe() {
        this.setSpecies("Giraffe");
        this.setSymbol(Symbol);
        this.setSpeedOnGround(3);
        this.setWasStuckOnY(false);
        this.setHunger(giraffeHunger);
        this.setLife(30);
        this.setStrength(8);
    }

    public boolean condition(Board board, int x, int y) {
        return ((board.getCaseAt(x, y).getType() == "Bush") || (board.getCaseAt(x, y).getType() == "Tree"));
    }
}
