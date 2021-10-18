package com.isne;

import com.isne.animals.Carnivorus;
import com.isne.animals.Herbivorus;
import com.isne.board.Board;
import com.isne.master.MasterHippopotamus;

public class Main {

    public static void main(String[] args) {
        Carnivorus John = new Carnivorus();
        John.setHunger(2);
        System.out.println(John.getHunger());
        Herbivorus hector = new Herbivorus();
        John.fight(hector);
        MasterHippopotamus pipou = MasterHippopotamus.getInstance();
        System.out.println(pipou);
        MasterHippopotamus pipou2 = MasterHippopotamus.getInstance();
        System.out.println(pipou2);


        Board newBoard = new Board(2);
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++)
                System.out.println(i+ ":"+j);
        }


    }
}
