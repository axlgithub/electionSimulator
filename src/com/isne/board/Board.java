package com.isne.board;

import com.isne.animals.Animal;

import static com.isne.Main.LIMIT;

public class Board {
    public final Case[][] grid;
    public int sizeX;
    public int sizeY;

    /**
     * Constructor for Board initialization
     *
     */
    public Board() {
        // Build empty board
        this.grid = new Case[LIMIT][LIMIT];
        // For coordinates iteration
        int x = 0;
        int y = 0;

        // Fill with Ground
        for (Case[] i:this.grid){
            for (Case caseElement: i){
                caseElement = new Ground();
                caseElement.setPosX(x);
                caseElement.setPosY(y);
                this.grid[x][y] = caseElement;
                y++;
            }
            y = 0;
            x++;
        }

        // Place Water
        // Place Plants
        // Place Animals
        // Place Masters
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
