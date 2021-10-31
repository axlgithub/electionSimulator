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
        for(int i=0; i<10;i++) {
            newBoard.makeASpeciesMove("Giraffe");
            newBoard.makeASpeciesMove("Hippopotamus");
            newBoard.makeASpeciesMove("Lion");
            newBoard.makeASpeciesMove("Crocodile");
        }



        //newBoard.startGame();

        // Testing only
        newBoard.show();
    }



}
