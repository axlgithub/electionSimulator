package com.isne;

import com.isne.animals.Carnivorous;
import com.isne.animals.Crocodile;
import com.isne.animals.Herbivorous;
import com.isne.board.Board;
import com.isne.board.Case;
import com.isne.master.MasterCrocodile;
import com.isne.master.MasterGiraffe;
import com.isne.master.MasterHippopotamus;
import com.isne.master.MasterLion;

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
                // Check if Master instance
                if (caseElement.master != null){
                    if (caseElement.master instanceof MasterLion){
                        MasterLion temp = (MasterLion) caseElement.master;
                        System.out.print(temp.getBackground() + temp.getSymbol() + ANSI_RESET);
                    }
                    if (caseElement.master instanceof MasterCrocodile){
                        MasterCrocodile temp = (MasterCrocodile) caseElement.master;
                        System.out.print(temp.getBackground() + temp.getSymbol() + ANSI_RESET);
                    }

                    if (caseElement.master instanceof MasterGiraffe){
                        MasterGiraffe temp = (MasterGiraffe) caseElement.master;
                        System.out.print(temp.getBackground() + temp.getSymbol() + ANSI_RESET);
                    }
                    if (caseElement.master instanceof MasterHippopotamus){
                        MasterHippopotamus temp = (MasterHippopotamus) caseElement.master;
                        System.out.print(temp.getBackground() + temp.getSymbol() + ANSI_RESET);
                    }
                    }
                else {
                    System.out.print(caseElement.backgroundColor + caseElement.getSymbol() + ANSI_RESET);
                }

                iterator++;
                if (iterator%LIMIT == 0){
                    System.out.print("\n");
                }
            }
        }

    }
    }
