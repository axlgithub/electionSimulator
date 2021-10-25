package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterGiraffe {
    private static MasterGiraffe single_instance = null;
    private final UUID id;
    private final String species;
    private final String Symbol = " G ";
    private final String background = "\u001B[40m";
    public Case house;

    private MasterGiraffe() {
        id = UUID.randomUUID();
        species = "Giraffe";
    }

    // Static method to create instance of MasterLion class
    public static MasterGiraffe getInstance() {
        if (single_instance == null)
            single_instance = new MasterGiraffe();

        return single_instance;
    }

    public UUID getId() {
        return id;
    }

    public String getBackground() {
        return background;
    }

    public String getSymbol() {
        return Symbol;
    }

    public String getSpecies() {
        return species;
    }
}
