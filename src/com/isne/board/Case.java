package com.isne.board;

import com.isne.animals.Animal;

import java.util.UUID;

public class Case {
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    private String symbol;
    private UUID id;
    private int posX;
    private int posY;
    private String type;
    private boolean isBusy;
    public Animal content = null;
    public String backgroundColor;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public Case() {
        this.setId(UUID.randomUUID());
        this.setBusy(false);
    }
}
