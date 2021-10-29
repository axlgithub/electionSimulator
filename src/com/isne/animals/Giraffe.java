package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Case;

import static com.isne.Main.LIMIT;

public class Giraffe extends Herbivorous {
    public Giraffe() {
        this.setSpecies("Giraffe");
    }

    public final String Symbol = " g ";

    public boolean condition(Board board, int x, int y) {
        return ((board.getCaseAt(x, y).getType() == "Bush") || (board.getCaseAt(x, y).getType() == "Tree"));
    }
}
