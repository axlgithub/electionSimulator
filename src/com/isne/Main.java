package com.isne;

import com.isne.board.Board;

public class Main {
    // Board parameters
    public static final int LIMIT = 30;
    public static final int SAFEZONESIZE = 3;
    public static final int ANIMALS = 5;
    public static final int SPEED = 200; // ms


    public static void main(String[] args) throws InterruptedException {
        // Game generation
        Board newBoard = new Board();
        newBoard.placeAnimals(ANIMALS);
        System.out.println(newBoard.getCaseAt(28,1).content.getSpecies());
        newBoard.getCaseAt(28,1).content.move(newBoard);

        //newBoard.startGame();

        // Testing only
        newBoard.show();
    }



}
