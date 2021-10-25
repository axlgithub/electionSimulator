package com.isne.board;

import com.isne.animals.Animal;
import com.isne.master.MasterCrocodile;
import com.isne.master.MasterGiraffe;
import com.isne.master.MasterHippopotamus;
import com.isne.master.MasterLion;

import static com.isne.Main.LIMIT;

/**
 * Default constructor, expensive in ressources
 */
public class Board {
    public final Case[][] grid;
    public int sizeX;
    public int sizeY;

    /**
     * Constructor for Board initialization
     */
    public Board() {
        // Build empty board
        this.grid = new Case[LIMIT][LIMIT];
        // For coordinates iteration
        int x = 0;
        int y = 0;

        // Fill with Ground
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

        // Reset position for reuse
        x = 0;
        y = 0;

        // Place SafeZones in corners by squares of 3
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
                    if (y > 26) {
                        caseElement = new SafeZone("Crocodile");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[x][y] = caseElement;
                    }
                    y++;
                }
            }

            if (x > 26) {
                for (Case caseElement : i) {
                    // Bottom left
                    if (y < 3) {
                        caseElement = new SafeZone("Giraffe");
                        caseElement.setPosX(x);
                        caseElement.setPosY(y);
                        this.grid[x][y] = caseElement;
                    }

                    // Bottom right
                    if (y > 26) {
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

        // Reset position for reuse
        x = 0;
        y = 0;

        // Place Water
        for (Case[] i : this.grid) {
            if (x > 9 && x < 23){
                for (Case caseElement : i) {
                    if (y > 9 && y < 23){
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

        // Reset position for reuse
        x = 0;
        y = 0;

        // Place Masters
        MasterLion MLion = MasterLion.getInstance();
        this.grid[1][1].setBusy(true);
        this.grid[1][1].master = MLion;
        MLion.house = this.grid[1][1];

        MasterCrocodile MCrocodile = MasterCrocodile.getInstance();
        this.grid[28][1].setBusy(true);
        this.grid[28][1].master = MCrocodile;
        MCrocodile.house = this.grid[28][1];

        MasterGiraffe MGiraffe = MasterGiraffe.getInstance();
        this.grid[1][28].setBusy(true);
        this.grid[1][28].master = MGiraffe;
        MGiraffe.house = this.grid[1][28];

        MasterHippopotamus MHippopotamus = MasterHippopotamus.getInstance();
        this.grid[28][28].setBusy(true);
        this.grid[28][28].master = MHippopotamus;
        MHippopotamus.house = this.grid[28][28];

        // Place Plants
        // Place Animals

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
}
