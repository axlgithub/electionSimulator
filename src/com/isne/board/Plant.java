package com.isne.board;

public class Plant extends Case {
    private final String background = "\u001B[42m";
    private final String Symbol = "...";

    public Plant() {
        super();
        //this.setType("Ground");
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
