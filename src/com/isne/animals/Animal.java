package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Case;
import com.isne.board.Plant;

import java.util.UUID;

public abstract class Animal {
    private int life;
    private int strength;
    private int hunger;
    private int speedOnGround;
    private int speedOnWatter;
    private UUID id;
    private boolean canSwim;
    private String species;

    public abstract void move();

    public Case findClosest(Board board, Plant plant){
        int maPositionX = this.position[0];
        int maPositionY = this.position[1];
        int distanceMin = board.sizeX + board.sizeY ;
        int closestPlantX;
        int closestPlantY;
        Case caseMin = new Case();
        for (int x=0; x<=board.sizeX;x++){
            for (int y=0; y<=board.sizeY;y++){
                if ( (maPositionX - x) + (maPositionY - y) < distanceMin) {
                    if (board[x][y].type() == plant) {
                        distanceMin=(maPositionX - x) + (maPositionY - y) ;
                    }
                }
            }
        }
        // Fetch la case correspondant aux coordonnées minimales et la retourner
        return caseMin;
    }

    public findClosest(Board board, Animal animal){

    };

    /* Getters and setters   */

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getSpeedOnGround() {
        return speedOnGround;
    }

    public void setSpeedOnGround(int speedOnGround) {
        this.speedOnGround = speedOnGround;
    }

    public int getSpeedOnWatter() {
        return speedOnWatter;
    }

    public void setSpeedOnWatter(int speedOnWatter) {
        this.speedOnWatter = speedOnWatter;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
