package com.isne;

import com.isne.animals.Carnivorus;
import com.isne.animals.Herbivorus;
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


    }
}
