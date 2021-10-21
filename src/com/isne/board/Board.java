package com.isne.board;

public class Board {
    public final Case[][] grid;

    public int sizeX;
    public int sizeY;

    public Board(int n) {
        this.grid = new Case[n][n];
    }

    public Case getCaseAt(int x, int y){
        return (this.grid[x][y]);
    }
}
