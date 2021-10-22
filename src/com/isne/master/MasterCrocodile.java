package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterCrocodile {
    private static MasterCrocodile single_instance = null;
    public Case house;
    private final UUID id;
    private final String species;
    public final String Symbol = " C ";

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
}

