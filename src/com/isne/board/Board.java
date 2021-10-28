package com.isne.board;

import com.isne.animals.*;
import com.isne.master.MasterCrocodile;
import com.isne.master.MasterGiraffe;
import com.isne.master.MasterHippopotamus;
import com.isne.master.MasterLion;

import java.util.Random;

import static com.isne.Main.LIMIT;

/**
 * Default constructor, expensive in ressources
 */
public class Board {
    public final Case[][] grid;
    public int sizeX;
    public int sizeY;

    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Constructor for Board initialization
     */
    public Board() {
        // Build empty board
        this.grid = new Case[LIMIT][LIMIT];

        // Fill whole board with Ground
        fillGround();

        placeSafeZones();
        placeWater();
        placeMasters();

        // Place Plants & Animals
        placeBeings();

    }

    /**
     * Place 5 animals of each, 9 bushs & 6 trees, only used in constructor
     */
    private void placeBeings() {
        int bushCount = 0;
        int treeCount = 0;

        // Bush
        while (bushCount <= 9) {
            int x = new Random().nextInt(30);
            int y = new Random().nextInt(30);

            // not busy and not water and not safezone
            if (!this.grid[x][y].isBusy() && this.grid[x][y].getType() != "Water" && this.grid[x][y].getType() != "SafeZone") {
                this.grid[x][y] = new Bush();
                bushCount++;
            }
        }

        // tree
        while (treeCount <= 6) {
            int x = new Random().nextInt(30);
            int y = new Random().nextInt(30);

            // not busy and not water and not safezone
            if (!this.grid[x][y].isBusy() && this.grid[x][y].getType() != "Water" && this.grid[x][y].getType() != "SafeZone") {
                this.grid[x][y] = new Tree();
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
                this.grid[x][y] = caseElement;
                y++;
            }
            y = 0;
            x++;
        }
    }

    /**
     * Place water cases bys squares of 3, only used in constructor
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
                        this.grid[x][y] = caseElement;
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
        this.grid[1][1].setBusy(true);
        this.grid[1][1].master = MLion;
        MLion.house = this.grid[1][1];

        MasterCrocodile MCrocodile = MasterCrocodile.getInstance();
        this.grid[LIMIT - 1][1].setBusy(true);
        this.grid[LIMIT - 1][1].master = MCrocodile;
        MCrocodile.house = this.grid[LIMIT - 1][1];

        MasterGiraffe MGiraffe = MasterGiraffe.getInstance();
        this.grid[1][LIMIT - 1].setBusy(true);
        this.grid[1][LIMIT - 1].master = MGiraffe;
        MGiraffe.house = this.grid[1][LIMIT - 1];

        MasterHippopotamus MHippopotamus = MasterHippopotamus.getInstance();
        this.grid[LIMIT - 1][LIMIT - 1].setBusy(true);
        this.grid[LIMIT - 1][LIMIT - 1].master = MHippopotamus;
        MHippopotamus.house = this.grid[LIMIT - 1][LIMIT - 1];
    }

    /**
     * Place safe zones, used in constructor
     */
    private void placeSafeZones() {
        int x = 0;
        int y = 0;
        for (Case[] i : this.grid) {
            if (x < 3) {
                for (Case caseElement : i) {
                    // Top left
                    if (y < 3) {
                        caseElement = new SafeZone("Lion");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[x][y] = caseElement;
                    }

                    // Top right
                    if (y > LIMIT - 3) {
                        caseElement = new SafeZone("Giraffe");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[x][y] = caseElement;
                    }
                    y++;
                }
            }

            if (x > LIMIT - 3) {
                for (Case caseElement : i) {
                    // Bottom left
                    if (y < 3) {
                        caseElement = new SafeZone("Crocodile");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[x][y] = caseElement;
                    }

                    // Bottom right
                    if (y > LIMIT - 3) {
                        caseElement = new SafeZone("Hippopotamus");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[x][y] = caseElement;
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
        return (this.grid[x][y]);
    }

    /**
     * Decrease hunger at each end of turn. If 0 then dies, removed from grid content and garbage collector should remove the unused object
     *
     * @param board
     */
    public void manageHunger(Board board) {
        Animal animal;
        for (int x = 0; x < board.sizeX; x++) {
            for (int y = 0; y < board.sizeY; y++) {
                if (board.getCaseAt(x, y).content != null) {
                    animal = board.getCaseAt(x, y).content;
                    animal.setHunger(animal.getHunger() - 1);
                    if (animal.getHunger() == 0) {
                        board.grid[x][y].content = null;
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

    public void generateAnimalsOnTheBoard(int numberOfAnimalsCreated){
        Lion newLion;
        Giraffe newGiraffe;
        Crocodile newCrocodile;
        Hippopotamus newHippopotamus;
        int x=0; // other counter to be able to set the new instance in an available spot.
        int c;
        for (int y=1; y<= numberOfAnimalsCreated; y++) {
            c = y;
            if(y>2 && y<=4){
                c=0;
                x = x+1;
            }
            if(y>4){
                x = c = y-4;
            }
            newLion = new Lion();
            newGiraffe = new Giraffe();
            newCrocodile = new Crocodile();
            newHippopotamus = new Hippopotamus();
            this.getCaseAt(1+c ,1+x).content= newLion;
            this.getCaseAt(1+c,LIMIT - 1-x).content=newGiraffe;
            this.getCaseAt(LIMIT - 1-c,LIMIT - 1-x).content=newHippopotamus;
            this.getCaseAt(LIMIT - 1-x,1+c).content=newCrocodile;
        }
    }

}
