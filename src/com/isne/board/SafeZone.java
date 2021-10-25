package com.isne.board;

import java.util.UUID;

public class SafeZone extends Case {
    private final String Symbol = "---";
    private final String background = "\u001B[40m";
    private String owner;

    public SafeZone(String owner) {
        super();
        this.setType("SafeZone");
        this.backgroundColor = getBackground();
        this.setSymbol(getSymbol());
        this.setOwner(owner);
    }

    public String getBackground() {return background;}

    @Override
    public String getSymbol() {return Symbol;}

    public String getOwner() {return owner;}

    public void setOwner(String owner) {this.owner = owner;}
}
