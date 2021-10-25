package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterHippopotamus {
    private static MasterHippopotamus single_instance = null;
    public Case house;
    private final UUID id;
    private final String species;
    private final String Symbol = " H ";
    private final String background = "\u001B[40m";

    private MasterHippopotamus() {
        id = UUID.randomUUID();
        species = "Hippopotamus";
    }

    // Static method to create instance of MasterLion class
    public static MasterHippopotamus getInstance() {
        if (single_instance == null)
            single_instance = new MasterHippopotamus();

        return single_instance;
    }

    public UUID getId() {return id;}

    public String getBackground() {return background;}

    public String getSymbol() {return Symbol;}

    public String getSpecies() {return species;}
}
