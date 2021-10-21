package com.isne.animals;

import com.isne.board.Board;

import static java.lang.Boolean.TRUE;

public class Crocodile extends Carnivorous {
    private int speedOnWatter;

    public Crocodile(){
        this.setHunger(25);
        this.setCanSwim(TRUE);
        this.setLife(50);
        this.setStrength(10);
        this.setSpeedOnGround(3);
        this.setSpeedOnWatter(3);
        this.setSpecies("Crocodile");
    }

    public int getSpeedOnWatter() {
        return speedOnWatter;
    }

    public boolean condition(Board board, int x, int y){
        return ((board.getCaseAt(x,y).content != null) && ( board.getCaseAt(x,y).content.getSpecies() == "Giraffe" || board.getCaseAt(x,y).content.getSpecies() == "Hippopotamus" ));
    }

    public void setSpeedOnWatter(int speedOnWatter) {
        this.speedOnWatter = speedOnWatter;
    }
}
