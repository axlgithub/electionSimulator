package com.isne.board;

import com.isne.animals.*;
import com.isne.master.MasterCrocodile;
import com.isne.master.MasterGiraffe;
import com.isne.master.MasterHippopotamus;
import com.isne.master.MasterLion;

import java.util.Random;

import static com.isne.Main.LIMIT;
import static com.isne.Main.SAFEZONESIZE;

/**
 * Default constructor, expensive in ressources
 */
public class Board {
    public static final String ANSI_RESET = "\u001B[0m";
    public final Case[][] grid;
    public int sizeX;
    public int sizeY;

    /**
     * Constructor for Board initialization
     */
    public Board() {
        // Build empty board
        this.grid = new Case[LIMIT][LIMIT];

        // Fill whole board with Ground
        fillGround();

        // Replace some cases with
        placeSafeZones();
        placeWater();
        placeMasters();
        placePlants();

    }

    /**
     * Place 5 animals of each, 9 bushs & 6 trees, only used in constructor
     */
    private void placePlants() {
        int bushCount = 0;
        int treeCount = 0;

        // Bush
        while (bushCount <= 9) {
            int x = new Random().nextInt(30);
            int y = new Random().nextInt(30);

            // not busy and not water and not safezone
            if (!this.getCaseAt(x,y).isBusy() && this.getCaseAt(x,y).getType() != "Water" && this.getCaseAt(x,y).getType() != "SafeZone") {
                this.grid[LIMIT-1-x][y] = new Bush();
                bushCount++;
            }
        }

        // tree
        while (treeCount <= 6) {
            int x = new Random().nextInt(30);
            int y = new Random().nextInt(30);

            // not busy and not water and not safezone
            if (!this.getCaseAt(x,y).isBusy() && this.getCaseAt(x,y).getType() != "Water" && this.getCaseAt(x,y).getType() != "SafeZone") {
                this.grid[LIMIT-1-x][y] = new Tree();
                treeCount++;
            }
        }

        // Lion
        // Crocodile
        // Giraffe
        // Hippopotamus


    }

    /**
     * Fill all board with ground, only used in constructor
     */
    private void fillGround() {
        int x = 0;
        int y = 0;

        for (Case[] i : this.grid) {
            for (Case caseElement : i) {
                caseElement = new Ground();
                caseElement.setPosX(x);
                caseElement.setPosY(y);
                this.grid[LIMIT-1-x][y] = caseElement;
                y++;
            }
            y = 0;
            x++;
        }
    }

    /**
     * Place water cases, only used in constructor
     */
    private void placeWater() {
        int x = 0;
        int y = 0;

        for (Case[] i : this.grid) {
            if (x > 9 && x < 23) {
                for (Case caseElement : i) {
                    if (y > 9 && y < 23) {
                        caseElement = new Water();
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[LIMIT-1-x][y] = caseElement;
                    }
                    y++;
                }
            }
            y = 0;
            x++;
        }
    }

    /**
     * Place all 4 masters, only used in constructor
     */
    private void placeMasters() {
        MasterLion MLion = MasterLion.getInstance();
        this.getCaseAt(0,0).setBusy(true);
        this.getCaseAt(0,0).master = MLion;
        MLion.house = this.getCaseAt(0,0);

        MasterCrocodile MCrocodile = MasterCrocodile.getInstance();
        this.getCaseAt(LIMIT-1,0).setBusy(true);
        this.getCaseAt(LIMIT-1,0).master = MCrocodile;
        MCrocodile.house = this.getCaseAt(LIMIT-1,0);

        MasterGiraffe MGiraffe = MasterGiraffe.getInstance();
        this.getCaseAt(0,LIMIT-1).setBusy(true);
        this.getCaseAt(0,LIMIT-1).master = MGiraffe;
        MGiraffe.house = this.getCaseAt(0,LIMIT-1);

        MasterHippopotamus MHippopotamus = MasterHippopotamus.getInstance();
        this.getCaseAt(LIMIT-1,LIMIT-1).setBusy(true);
        this.getCaseAt(LIMIT-1,LIMIT-1).master = MHippopotamus;
        MHippopotamus.house = this.getCaseAt(LIMIT-1,LIMIT-1);
    }

    /**
     * Place safe zones, used in constructor
     */
    private void placeSafeZones() {
        int x = 0;
        int y = 0;
        for (Case[] i : this.grid) {
            if (x < SAFEZONESIZE) {
                for (Case caseElement : i) {
                    // Top left
                    if (y < SAFEZONESIZE) {
                        caseElement = new SafeZone("Lion");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[LIMIT-1-x][y] = caseElement;
                    }

                    // Top right
                    if (y >= LIMIT - SAFEZONESIZE) {
                        caseElement = new SafeZone("Giraffe");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[LIMIT-1-x][y] = caseElement;
                    }
                    y++;
                }
            }

            if (x >= LIMIT - SAFEZONESIZE) {
                for (Case caseElement : i) {
                    // Bottom left
                    if (y < SAFEZONESIZE) {
                        caseElement = new SafeZone("Crocodile");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[LIMIT-1-x][y] = caseElement;
                    }

                    // Bottom right
                    if (y >= LIMIT - SAFEZONESIZE) {
                        caseElement = new SafeZone("Hippopotamus");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[LIMIT-1-x][y] = caseElement;
                    }
                    y++;
                }
            }

            y = 0;
            x++;
        }
    }

    /**
     * Return Case object from coordinates
     *
     * @param x
     * @param y
     * @return
     */
    public Case getCaseAt(int x, int y) {
        return (this.grid[LIMIT-1-x][y]);
    }

    /**
     * Decrease hunger at each end of turn. If 0 then dies, removed from grid content and garbage collector should remove the unused object
     */
    public void manageHunger() {
        Animal animal;
        for (int x = 0; x < this.sizeX; x++) {
            for (int y = 0; y < this.sizeY; y++) {
                if (this.getCaseAt(x, y).content != null) {
                    animal = this.getCaseAt(x, y).content;
                    animal.setHunger(animal.getHunger() - 1);
                    if (animal.getHunger() == 0) {
                        this.getCaseAt(x,y).content = null;
                    }
                }
            }
        }
    }

    /**
     * Show board content
     */
    public void show() {
        int iterator = 0;
        for (Case[] i : this.grid) {
            for (Case caseElement : i) {
                // Check if Master instance
                if (caseElement.master != null) {
                    if (caseElement.master instanceof MasterLion) {
                        MasterLion temp = (MasterLion) caseElement.master;
                        System.out.print(temp.getBackground() + temp.getSymbol() + ANSI_RESET);
                    }
                    if (caseElement.master instanceof MasterCrocodile) {
                        MasterCrocodile temp = (MasterCrocodile) caseElement.master;
                        System.out.print(temp.getBackground() + temp.getSymbol() + ANSI_RESET);
                    }

                    if (caseElement.master instanceof MasterGiraffe) {
                        MasterGiraffe temp = (MasterGiraffe) caseElement.master;
                        System.out.print(temp.getBackground() + temp.getSymbol() + ANSI_RESET);
                    }
                    if (caseElement.master instanceof MasterHippopotamus) {
                        MasterHippopotamus temp = (MasterHippopotamus) caseElement.master;
                        System.out.print(temp.getBackground() + temp.getSymbol() + ANSI_RESET);
                    }
                }
                // Check if contains Animal instance
                else if (caseElement.content != null) {
                    System.out.print(caseElement.backgroundColor + caseElement.content.getSymbol() + ANSI_RESET);
                } else {
                    System.out.print(caseElement.backgroundColor + caseElement.getSymbol() + ANSI_RESET);
                }

                iterator++;
                if (iterator % LIMIT == 0) {
                    System.out.print("\n");
                }
            }
        }
    }

    /**
     * initialise the board with the chosen number of animal instances.
     *
     * @param numberOfAnimalsToCreate, set the number of animals which will be created for each species.
     */
    public void placeAnimals(int numberOfAnimalsToCreate) {
        int numberOfAnimalsAlreadyCreated = 0;
        Lion newLion;
        Giraffe newGiraffe;
        Crocodile newCrocodile;
        Hippopotamus newHippopotamus;

        for (int x = 0; x < SAFEZONESIZE; x++) {
            for (int y = 0; y < SAFEZONESIZE; y++) { // those loops in order to browse the nine cases of the safe-zone.
                if (!this.getCaseAt(x, y).isBusy()) { // in order to avoid putting an element on the master
                    newLion = new Lion(); // at each new loop we add one animal of each species on the board.
                    newGiraffe = new Giraffe();
                    newCrocodile = new Crocodile();
                    newHippopotamus = new Hippopotamus();
                    this.getCaseAt(1 + x, 1 + y).content = newLion;
                    this.getCaseAt(1 + x, LIMIT - 1 - y).content = newGiraffe;
                    this.getCaseAt(LIMIT - 1 - x, LIMIT - 1 - y).content = newHippopotamus;
                    this.getCaseAt(LIMIT - 1 - x, 1 + y).content = newCrocodile;
                    numberOfAnimalsAlreadyCreated += 1;
                    if (numberOfAnimalsAlreadyCreated == numberOfAnimalsToCreate) {
                        return;
                    }
                }
            }
        }
    }


}
