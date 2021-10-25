package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterCrocodile {
    private static MasterCrocodile single_instance = null;
    private final UUID id;
    private final String species;
    private final String Symbol = " C ";
    private final String background = "\u001B[40m";
    public Case house;

    private MasterCrocodile() {
        id = UUID.randomUUID();
        species = "Crocodile";
    }

    // Static method to create instance of MasterLion class
    public static MasterCrocodile getInstance() {
        if (single_instance == null)
            single_instance = new MasterCrocodile();

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

