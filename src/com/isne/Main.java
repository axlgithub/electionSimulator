package com.isne;

import com.isne.board.Board;

public class Main {
    // Board parameters
    public static final int LIMIT = 30;
    public static final int SAFEZONESIZE = 3;
    public static final int ANIMALS = 5;


    public static void main(String[] args) {
        // Game generation
        Board newBoard = new Board();
        // Display TODO : at each step refresh (4 times in turn)
        clearConsole();
        newBoard.placeAnimals(ANIMALS);
        newBoard.show();
    }

    /**
     * Clear console, only works on execution (not in IDE)
     */
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
