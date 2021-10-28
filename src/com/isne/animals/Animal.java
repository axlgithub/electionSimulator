package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Case;

import java.util.UUID;

public abstract class Animal {
    private int life;
    private int strength;
    private int hunger;
    private int speedOnGround;
    private UUID id;
    private boolean canSwim;
    private String species;
    private int positionX;
    private int positionY;


    public void move( Board board){
        Case closestFood = this.findClosestFood( board);
        positionX=this.getPositionX();
        positionY=this.getPositionY();
        int destinationX = closestFood.getPosX();
        int destinationY = closestFood.getPosY();
        int directionX;
        int directionY;
        for( int i=0;i<=this.getSpeedOnGround();i++ ){
            directionX = this.findDirection(destinationX,positionX);
            directionY = this.findDirection(destinationY,positionY);
            if ( ! this.moveFromOneTileX(board,positionX,positionY, directionX) ){
                this.moveFromOneTileY( board, positionX, positionY, directionY);
            }
        }
    }

    /**
     * return true if the animal as been able to move on the x-axis, false otherwise. The direction parameter is either 1 or -1 or 0. It saids if the animal must go to the right, left of its actual position.
     * @param board
     * @param PositionX
     * @param PositionY
     * @param direction
     * @return
     */
    public boolean moveFromOneTileX ( Board board, int PositionX, int PositionY, int direction ){ //direction equals + or - 1 according to the direction you wanna go
        Case currentCase = board.getCaseAt(PositionX,PositionY );
        Case wantedCase = board.getCaseAt(PositionX + direction,PositionY );
        if ( wantedCase.getType()=="Ground" && wantedCase.content == null && direction != 0){
            wantedCase.content= this;
            currentCase.content=null;
            return true;
        }
        if ( wantedCase.getType()=="Water" && this.canSwim && wantedCase.content == null && direction != 0){
            wantedCase.content= this;
            currentCase.content=null;
            return true;
        }
        return false;
    }

    /**
     * return true if the animal as been able to move on the x-axis, false otherwise. The direction parameter is either 1 or -1 or 0. It saids if the animal must go to the right, left of its actual position.
     * @param board
     * @param PositionX
     * @param PositionY
     * @param direction
     * @return
     */
    public void moveFromOneTileY ( Board board, int PositionX, int PositionY, int direction ){ //direction equals + or - 1 according to the direction you wanna go
        Case wantedCase = board.getCaseAt(PositionX ,PositionY + direction);
        Case currentCase = board.getCaseAt(PositionX,PositionY );
        if ( wantedCase.getType()=="Ground" && wantedCase.content == null && direction != 0){
            wantedCase.content= this;
            currentCase.content=null;
        }
        if ( wantedCase.getType()=="Water" && this.canSwim && wantedCase.content == null && direction != 0){
            wantedCase.content= this;
            currentCase.content=null;
        }
    }

    public int findDirection( int destination, int position){
        return Integer.compare(destination - position , 0);
    }


    public double distance(int abscissa1, int ordinate1, int abscissa2, int ordinate2) {
        return (Math.sqrt(Math.pow((abscissa1 - abscissa2), 2) + Math.pow((ordinate1 - ordinate2), 2)));
    }


    public Case findClosestFood(Board board) {
        int maPositionX = this.getPositionX();
        int maPositionY = this.getPositionY();
        double distanceMin = board.sizeX + board.sizeY;
        int closestX = board.sizeX;
        int closestY = board.sizeY;
        Case caseMin = new Case();
        for (int x = 0; x < board.sizeX; x++) {
            for (int y = 0; y < board.sizeY; y++) {
                if (distance(maPositionX, maPositionY, x, y) < distanceMin) {
                    if (this.condition(board, x, y)) {
                        distanceMin = (maPositionX - x) + (maPositionY - y);
                        closestX = x;
                        closestY = y;
                    }
                }
            }
        }
        return board.getCaseAt(closestX, closestY);
    }

    protected abstract boolean condition(Board board, int x, int y);

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

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}


