package com.isne.animals;

import static java.lang.Boolean.TRUE;

public class Crocodile extends Carnivorus {
    private int speedOnWatter;

    public Crocodile(){
        this.setHunger(25);
        this.setCanSwim(TRUE);
        this.setLife(50);
        this.setStrength(10);
        this.setSpeedOnGround(3);
        this.setSpeedOnWatter(3);
        this.setSpecies("Crocodile");
        this.setPositionX();
        this.setPositionY();
    }

    public int getSpeedOnWatter() {
        return speedOnWatter;
    }

    public void setSpeedOnWatter(int speedOnWatter) {
        this.speedOnWatter = speedOnWatter;
    }
}
