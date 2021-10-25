package com.isne.board;

public class Tree extends Plant {
    private final String Symbol = " T ";

    public Tree() {
        super();
        super.setSymbol(getSymbol());
        super.setType("Tree");
    }

    @Override
    public String getSymbol() {
        return Symbol;
    }

}
