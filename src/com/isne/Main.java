package com.isne;

import com.isne.animals.Carnivorous;
import com.isne.animals.Herbivorous;
import com.isne.board.Board;
import com.isne.board.Case;
import com.isne.master.MasterHippopotamus;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
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
        // See what is inside
        int iterator = 0;
        for (Case[] i:newBoard.grid){
            for (Case caseElement: i){
                System.out.print(caseElement.backgroundColor + caseElement.getSymbol() + ANSI_RESET);
                iterator++;
                if (iterator%LIMIT == 0){
                    System.out.print("\n");
                }
            }
        }

    }
    }
