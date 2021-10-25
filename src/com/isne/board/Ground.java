package com.isne.board;

public class Ground extends Case {
    private final String background = "\u001B[43m";
    private final String Symbol = "...";

    public Ground() {
        super();
        this.setType("Ground");
        this.backgroundColor = getBackground();
        this.setSymbol(getSymbol());
    }

    public String getBackground() {
        return background;
    }

    @Override
    public String getSymbol() {
        return Symbol;
    }
}
