package com.isne.animals;

import com.isne.board.Case;

public class Carnivorus extends Animal{
    public void move(){
        this.setHunger(5);
    }

    public boolean fight( Animal connard ){
        System.out.println(connard.getHunger());
        return true;
    }

    public Case nearestPrey(){
        Case superCase = new Case();
        return(superCase);
    }

}
