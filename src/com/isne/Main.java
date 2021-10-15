package com.isne;

import com.isne.animals.Carnivorus;
import com.isne.animals.Herbivorus;

public class Main {

    public static void main(String[] args) {
        Carnivorus John = new Carnivorus();
        John.setHunger(2);
        System.out.println(John.getHunger());
        Herbivorus hector = new Herbivorus();
        John.fight(hector);

    }
}
