package com.isne;

import com.isne.animals.Carnivorous;
import com.isne.animals.Herbivorous;
import com.isne.board.Board;
import com.isne.board.Case;
import com.isne.master.MasterCrocodile;
import com.isne.master.MasterGiraffe;
import com.isne.master.MasterHippopotamus;
import com.isne.master.MasterLion;

public class Main {

    public static final int LIMIT = 30;


    public static void main(String[] args) {
        // Tests
        Carnivorous John = new Carnivorous();
        John.setHunger(2);
        System.out.println(John.getHunger());
        Herbivorous hector = new Herbivorous();
        John.fight(hector);
        MasterHippopotamus pipou = MasterHippopotamus.getInstance();
        System.out.println(pipou);
        MasterHippopotamus pipou2 = MasterHippopotamus.getInstance();
        System.out.println(pipou2);


        // Game generation
        Board newBoard = new Board();
        // Display TODO : at each step refresh (4 times in turn)
        clearConsole();
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
