package com.isne.board;

public class Bush extends Plant {
    private final String Symbol = " B ";

    public Bush() {
        super();
        super.setSymbol(getSymbol());
        super.setType("Bush");
    }

    @Override
    public String getSymbol() {
        return Symbol;
    }
}
