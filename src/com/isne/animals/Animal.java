package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Case;

import java.util.UUID;

import static com.isne.Main.LIMIT;

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
    private String Symbol;


    public void move(Board board) {
        Case closestFood = this.findClosestFood(board);
        System.out.println("the closest food is at: ");
        System.out.println(closestFood.getPosX());
        System.out.println(closestFood.getPosY());
        positionX = this.getPositionX();
        positionY = this.getPositionY();
        int destinationX = closestFood.getPosX();
        int destinationY = closestFood.getPosY();
        int directionX;
        int directionY;
        for (int i = 0; i <= this.getSpeedOnGround(); i++) {
            directionX = this.findDirection(destinationX, positionX);
            directionY = this.findDirection(destinationY, positionY);
            if (!this.moveFromOneTileX(board, positionX, positionY, directionX)) {
                this.moveFromOneTileY(board, positionX, positionY, directionY);
            }
        }
    }

    /**
     * return true if the animal as been able to move on the x-axis, false otherwise. The direction parameter is either 1 or -1 or 0. It saids if the animal must go to the right, left of its actual position.
     *
     * @param board
     * @param PositionX
     * @param PositionY
     * @param direction
     * @return
     */
    public boolean moveFromOneTileX(Board board, int PositionX, int PositionY, int direction) { //direction equals + or - 1 according to the direction you wanna go
        Case currentCase = board.getCaseAt(PositionX, PositionY);
        Case wantedCase = board.getCaseAt(PositionX + direction, PositionY);
        if (wantedCase.getType() == "Ground" && wantedCase.content == null && direction != 0) {
            wantedCase.content = this;
            this.setPositionX(PositionX + direction);
            this.setPositionY(PositionY);
            currentCase.content = null;
            return true;
        }
        if (wantedCase.getType() == "Water" && this.canSwim && wantedCase.content == null && direction != 0) {
            wantedCase.content = this;
            this.setPositionX(PositionX + direction);
            this.setPositionY(PositionY);
            currentCase.content = null;
            return true;
        }
        return false;
    }

    /**
     * return true if the animal as been able to move on the x-axis, false otherwise. The direction parameter is either 1 or -1 or 0. It saids if the animal must go to the right, left of its actual position.
     *
     * @param board
     * @param PositionX
     * @param PositionY
     * @param direction
     * @return
     */
    public void moveFromOneTileY(Board board, int PositionX, int PositionY, int direction) { //direction equals + or - 1 according to the direction you wanna go
        Case wantedCase = board.getCaseAt(PositionX, PositionY + direction);
        Case currentCase = board.getCaseAt(PositionX, PositionY);
        if (wantedCase.getType() == "Ground" && wantedCase.content == null && direction != 0) {
            wantedCase.content = this;
            this.setPositionX(PositionX);
            this.setPositionY(PositionY + direction);
            currentCase.content = null;
        }
        if (wantedCase.getType() == "Water" && this.canSwim && wantedCase.content == null && direction != 0) {
            wantedCase.content = this;
            this.setPositionX(PositionX);
            this.setPositionY(PositionY + direction);
            currentCase.content = null;
        }
    }

    public int findDirection(int destination, int position) {
        return Integer.compare(destination - position, 0);
    }


    public double distance(int abscissa1, int ordinate1, int abscissa2, int ordinate2) {
        return (Math.sqrt(Math.pow((abscissa1 - abscissa2), 2) + Math.pow((ordinate1 - ordinate2), 2)));
    }


    /**
     * Return Case from closest prey
     * @param board
     * @return
     */
    public Case findClosestFood(Board board) {
        System.out.println("je suis une:");
        System.out.println(this.getSpecies());
        System.out.println("ma position est: ");
        int maPositionX = this.getPositionX();
        System.out.println(maPositionX);
        int maPositionY = this.getPositionY();
        System.out.println(maPositionY);
        double distanceMin = LIMIT*2;
        int closestX = LIMIT;
        int closestY = LIMIT;

        for (int x = 0; x < LIMIT; x++) {
            for (int y = 0; y < LIMIT; y++) {
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

    public String getSymbol() {return Symbol;}

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

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


