package com.isne.board;

import java.util.UUID;

public class SafeZone extends Case {
    private final String Symbol = "---";
    private final String background = "\u001B[40m";
    private UUID id;
    private int height;
    private int width;
    private String owner;

    public SafeZone() {
        super();
        this.setType("SafeZone");
        this.backgroundColor = getBackground();
        this.setSymbol(getSymbol());
    }

    public String getBackground() {return background;}

    @Override
    public String getSymbol() {return Symbol;}
}
