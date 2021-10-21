package com.isne;

import com.isne.animals.Animal;
import com.isne.animals.Carnivorus;
import com.isne.animals.Herbivorus;
import com.isne.board.Board;
import com.isne.board.Case;
import com.isne.board.Ground;
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


        Board newBoard = new Board();

        for (Case[] i:newBoard.grid){
            for (Case caseElement: i){
                System.out.println(caseElement.getId());
            }
        }

        System.out.println("test");
    }
    }
