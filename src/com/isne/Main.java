package com.isne;

import com.isne.board.Board;

public class Main {
    // Board parameters
    public static final int LIMIT = 30;
    public static final int SAFEZONESIZE = 3;
    public static final int ANIMALS = 5;
    public static final int SPEED = 200; // ms
    public static final int NBUSHES = 9;
    public static final int NTREES = 6;

    public static void main(String[] args) throws InterruptedException {
        // Game generation
        Board newBoard = new Board();
        newBoard.placeAnimals(ANIMALS);

        newBoard.startGame();

        // Testing only
        //newBoard.show();
    }


}
