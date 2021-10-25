package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterLion {
    private static MasterLion single_instance = null;
    public Case house;
    private final UUID id;
    private final String species;
    private final String Symbol = " L ";
    private final String background = "\u001B[40m";

    private MasterLion() {
        id = UUID.randomUUID();
        species = "Lion";
    }

    // Static method to create instance of MasterLion class
    public static MasterLion getInstance() {
        if (single_instance == null)
            single_instance = new MasterLion();

        return single_instance;
    }

    public UUID getId() {return id;}

    public String getBackground() {return background;}

    public String getSymbol() {return Symbol;}

    public String getSpecies() {return species;}
}
