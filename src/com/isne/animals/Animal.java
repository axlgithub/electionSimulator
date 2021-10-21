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
    private int positionX;
    private int positionY;


    public abstract void move();

    public double distance(int abscissa1, int ordinate1, int abscissa2, int ordinate2){
        return (Math.sqrt( Math.pow ( (abscissa1-abscissa2) , 2 ) + Math.pow ( (ordinate1-ordinate2) , 2 ) ));
    }

    public Case findClosest(Board board, Plant plant){
        int maPositionX = this.getPositionX();
        int maPositionY = this.getPositionY();
        double distanceMin = board.sizeX + board.sizeY ;
        int closestPlantX = board.sizeX;
        int closestPlantY = board.sizeY;
        Case caseMin = new Case();
        for (int x=0; x<board.sizeX;x++){
            for (int y=0; y<board.sizeY;y++){
                if ( distance(maPositionX,maPositionY,x,y) < distanceMin) {
                    if (board.getCaseAt(x,y).getType() == "plant") {
                        distanceMin=(maPositionX - x) + (maPositionY - y) ;
                        closestPlantX = x;
                        closestPlantY = y;
                    }
                }
            }
        }
        return board.getCaseAt(closestPlantX,closestPlantY);
    }

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

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }
}


