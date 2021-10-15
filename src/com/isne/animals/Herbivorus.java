package com.isne.animals;

import com.isne.board.*;

public class Herbivorus extends Animal{
    public void move(){
        this.setHunger(5);
    }

    public void eat( Plant plant){
        System.out.println("super ! ");
    }

    public Case nearestPlant(){
        Case superCase = new Case();
        return(superCase);
    }
}
