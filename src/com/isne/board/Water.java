package com.isne.board;

public class Water extends Case {
    private final  String background = "\u001B[44m";
    private final String Symbol = "...";

    public Water() {
        super();
        this.setType("Water");
        this.backgroundColor = background;
        this.setSymbol(Symbol);
    }

    public String getBackground() {return background;}

    @Override
    public String getSymbol() {return Symbol;}
}
