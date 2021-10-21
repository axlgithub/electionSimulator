package com.isne.board;

public class Ground extends Case {
    public String background = "\u001B[43m";
    public String Symbol = "...";

    public Ground() {
        super();
        this.setType("Ground");
        this.backgroundColor = background;
        this.setSymbol(Symbol);
    }
}
