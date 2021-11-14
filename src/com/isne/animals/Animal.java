package com.isne.animals;

import com.isne.board.Board;
import com.isne.board.Case;
import com.isne.board.Ground;

import java.util.UUID;

import static com.isne.Main.LIMIT;
import static com.isne.Main.SAFEZONESIZE;
import static com.isne.animals.Crocodile.crocodileHunger;
import static com.isne.animals.Giraffe.giraffeHunger;
import static com.isne.animals.Hippopotamus.hippopotamusHunger;
import static com.isne.animals.Lion.lionHunger;

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
    private boolean hasAlreadyMoved;
    private boolean wasStuckOnY; // if an animal is stuck on Y we need to move it on the x axis. But the next move musn't be on the x axis or it will be stuck again. This is why there is this variable.


    /**
     * This method manage all the mouvement part of an animal
     * Also handle eat
     *
     * @param board
     * @return true if it is next to its food location, false otherwise
     */
    public boolean move(Board board) {
        int[] closestFoodCoordinates = this.findClosestFood(board);
        int positionX;
        int positionY;
        int destinationX = closestFoodCoordinates[0];
        int destinationY = closestFoodCoordinates[1];
        int directionX;
        int directionY;
        for (int i = 0; i < this.getSpeedOnGround(); i++) {
            positionX = this.getPositionX();
            positionY = this.getPositionY();
            directionX = this.findDirection(destinationX, positionX);
            directionY = this.findDirection(destinationY, positionY);
            if (distance(positionX, positionY, destinationX, destinationY) == 1) {

                // If carnivorous near herbirovous
                Animal prey = board.getCaseAt(destinationX, destinationY).content;
                if (prey != null) {
                    boolean status = this.eat(prey);

                    // if successful, kill herbivorous TODO carnivor go back to dest for generation
                    if (status) {
                        board.getCaseAt(destinationX, destinationY).content = null;
                        // refill hunger
                        if (this instanceof Crocodile){
                            this.hunger = crocodileHunger;
                            spawnAnimal(board);
                        }
                        if (this instanceof Lion){
                            this.hunger = lionHunger;
                            spawnAnimal(board);
                        }
                    }
                }
                // else herbivorous near plant
                else {
                    if (board.grid[LIMIT - 1 - destinationY][destinationX].getType() == "Bush"){
                        Board.bushNumber--;
                    } else {

                        Board.treeNumber--;
                    }
                    // note that positions attributes are inversed from grid
                    board.grid[LIMIT - 1 - destinationY][destinationX] = new Ground();
                    board.grid[LIMIT - 1 - destinationY][destinationX].setPosX(destinationY);
                    board.grid[LIMIT - 1 - destinationY][destinationX].setPosY(destinationX);
                    if (this instanceof Giraffe){
                        this.hunger = giraffeHunger;
                        spawnAnimal(board);
                    }
                    if (this instanceof Hippopotamus){
                        this.hunger = hippopotamusHunger;
                        spawnAnimal(board);
                    }
                }
                return true; //if the animal is next to its food location, no need to move anymore.
            }
            if (!this.moveFromOneTile(board, directionX, true)) { // If wadStuckOnY is true then it has to move on Y axis first.
                this.setWasStuckOnY(false); // the animal will move on Y first we can re-initialize the variable.
                if (!this.moveFromOneTile(board, directionY, false)) { //if the animal didn't move in x or in y then he is stuck, the functions bellow are here to make it move
                    if (destinationX - positionX != 0) { // if the animal isn't near the food on the x axis, then it is stuck by an object near from him on the x-axis we need to make a move on the y-axis first.
                        if (!this.moveFromOneTileWhenStuck(board, 1, true)) {
                            this.moveFromOneTileWhenStuck(board, -1, true);
                        }
                    } else { // it is stuck on the y axis, need to move on the y one.
                        if (destinationY - positionY != 0) {
                            if (!this.moveFromOneTileWhenStuck(board, 1, false)) {
                                this.moveFromOneTileWhenStuck(board, -1, false);
                            }
                        }
                    }
                }
            }
        }
        this.setHasAlreadyMoved(true);
        return false;
    }

    /**
     * Spawn one instance of needed animal
     * @param board
     */
    public void spawnAnimal(Board board) {
        for (int x = 0; x < SAFEZONESIZE; x++) {
            for (int y = 0; y < SAFEZONESIZE; y++) {
                if (!board.getCaseAt(x, y).isBusy()) {
                    if (this instanceof Lion){
                        board.getCaseAt(x, y).content = new Lion();
                        board.getCaseAt(x, y).content.setPositionX(x);
                        board.getCaseAt(x, y).content.setPositionX(y);
                        return;
                    }
                    if (this instanceof Crocodile){
                        board.getCaseAt(LIMIT - 1 - x, y).content = new Crocodile();
                        board.getCaseAt(LIMIT - 1 - x, y).content.setPositionX(LIMIT - 1 - x);
                        board.getCaseAt(LIMIT - 1 - x, y).content.setPositionX(y);
                        return;
                    }
                    if (this instanceof Hippopotamus){
                        board.getCaseAt(LIMIT - 1 - x, LIMIT - 1 - y).content = new Hippopotamus();
                        board.getCaseAt(LIMIT - 1 - x, LIMIT - 1 - y).content.setPositionX(LIMIT - 1 - x);
                        board.getCaseAt(LIMIT - 1 - x, LIMIT - 1 - y).content.setPositionX(LIMIT - 1 - y);
                        return;
                    }
                    if (this instanceof Giraffe){
                        board.getCaseAt(x, LIMIT - 1 - y).content = new Giraffe();
                        board.getCaseAt(x, LIMIT - 1 - y).content.setPositionX(x);
                        board.getCaseAt(x, LIMIT - 1 - y).content.setPositionX(LIMIT - 1 - y);
                        return;
                    }
                }

            }
        }}

    /**
     * Eat (only for carinorous)
     *
     * @return
     */
    protected boolean eat(Animal animal) {
        return false;
    }

    /**
     * The animal can be stuck by a tree or a bush or another animal on its path. This method is here to unlock it
     *
     * @param board
     * @param direction
     * @param stuckOnX
     * @return
     */
    public boolean moveFromOneTileWhenStuck(Board board, int direction, boolean stuckOnX) {
        int positionX = this.positionX;
        int positionY = this.positionY;
        Case wantedCase;
        Case currentCase = board.getCaseAt(positionX, positionY);
        if (stuckOnX) {
            if (positionY + direction >= LIMIT || positionY + direction < 0) { // checks if the wanted case is not outside the board.
                return false;
            }
            wantedCase = board.getCaseAt(positionX, positionY + direction); //sets the case id to unclock the animal.
        } else {
            if (positionX + direction >= LIMIT || positionX + direction < 0) {
                return false;
            }
            wantedCase = board.getCaseAt(positionX + direction, positionY);
            this.setWasStuckOnY(true);
        }
        if ((wantedCase.getType() == "Ground" || wantedCase.getType() == "SafeZone" || (wantedCase.getType() == "Water" && this.canSwim)) && wantedCase.content == null) { // si le deplacement sur la wanted case est possible
            this.makeTheMove(wantedCase, currentCase);
            return true;
        }
        return false;
    }


    /**
     * @param board
     * @param direction 1 if you want to go up or right, -1 to go down or left
     * @param moveOnX   if it is true the move will be on X axis otherwise on Y axis
     * @return true if the animal as been able to move, false otherwise. The direction parameter is either 1 or -1 or 0. It says if the animal must go to the right, left, up down of its actual position.
     */
    public boolean moveFromOneTile(Board board, int direction, boolean moveOnX) {
        if (direction == 0) {
            return false;
        }
        int positionX = this.getPositionX();
        int positionY = this.getPositionY();
        Case currentCase = board.getCaseAt(positionX, positionY);
        Case wantedCase;
        if (moveOnX) {
            if(positionX + direction>=LIMIT){
                return false;
            }
            wantedCase = board.getCaseAt(positionX + direction, positionY);
            if (this.getWasStuckOnY()) {
                return false; // the animal needs to move on y-axis first
            }
        }
        else {
            if(positionY + direction>=LIMIT){
                return false;
            }
            wantedCase = board.getCaseAt(positionX, positionY + direction);
        }
        if ((wantedCase.getType() == "Ground" || wantedCase.getType() == "SafeZone" || (wantedCase.getType() == "Water" && this.canSwim)) && wantedCase.content == null) {
            this.makeTheMove(wantedCase, currentCase);
            return true;
        }
        return false;
    }

    /**
     * Method which actually make the animal move from one tile to antoher
     *
     * @param wantedCase
     * @param currentCase
     */
    public void makeTheMove(Case wantedCase, Case currentCase) {
        wantedCase.content = this;
        currentCase.setBusy(false); // free actual case
        this.setPositionX(wantedCase.getPosX());
        this.setPositionY(wantedCase.getPosY());
        wantedCase.setBusy(true); // lock wanted case
        currentCase.content = null;
    }

    /**
     * @param destination
     * @param position
     * @return -1 if the indice of the direction is lower than the position of the animal, +1 if it is higher, 0 if it is the same
     */
    public int findDirection(int destination, int position) {
        return Integer.compare(destination - position, 0);
    }

    /**
     * @param abscissa1
     * @param ordinate1
     * @param abscissa2
     * @param ordinate2
     * @return the distance in cases between two cases
     */
    public double distance(int abscissa1, int ordinate1, int abscissa2, int ordinate2) {
        return (Math.sqrt(Math.pow((abscissa1 - abscissa2), 2) + Math.pow((ordinate1 - ordinate2), 2)));
    }


    /**
     * @param board
     * @return an array with the position X and Y of the closest food
     */
    public int[] findClosestFood(Board board) {
        int maPositionX = this.getPositionX();
        int maPositionY = this.getPositionY();
        double distanceMin = LIMIT * 2;
        int closestX = LIMIT;
        int closestY = LIMIT;
        for (int x = 0; x < LIMIT; x++) {
            for (int y = 0; y < LIMIT; y++) {
                if (distance(maPositionX, maPositionY, x, y) < distanceMin) {
                    if (this.condition(board, x, y)) {
                        distanceMin = distance(maPositionX, maPositionY, x, y);
                        closestX = x;
                        closestY = y;
                    }
                }
            }
        }
        int[] arr = {closestX, closestY};
        return arr;
    }

    protected abstract boolean condition(Board board, int x, int y);

    /* Getters and setters   */

    public String getSymbol() {
        return Symbol;
    }

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

    public boolean getWasStuckOnY() {
        return wasStuckOnY;
    }

    public void setWasStuckOnY(boolean wasStuckOnY) {
        this.wasStuckOnY = wasStuckOnY;
    }


    public boolean getHasAlreadyMoved() {
        return hasAlreadyMoved;
    }

    public void setHasAlreadyMoved(boolean hasAlreadyMoved) {
        this.hasAlreadyMoved = hasAlreadyMoved;
    }

}


