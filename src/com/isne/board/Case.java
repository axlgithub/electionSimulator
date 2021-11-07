package com.isne.board;

import com.isne.animals.Animal;

import java.util.UUID;

public class Case {

    public Animal content = null;
    public Object master = null;
    public String backgroundColor;
    private String symbol;
    private UUID id;
    private int posX;
    private int posY;
    private String type;
    private boolean isBusy;

    public Case() {
        this.setId(UUID.randomUUID());
        this.setBusy(false);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getPosX() {
        return posY;
    } //Y and not X because we inverted the coordinated to respect [x][y] and not [y][x]

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posX;
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
}
