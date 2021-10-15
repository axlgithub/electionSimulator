package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterCrocodile {
    private static MasterCrocodile single_instance = null;
    private UUID id;
    private String specie;
    public Case house;

    private MasterCrocodile()
    {
        id = UUID.randomUUID();
        specie = "Crocodile";
    }

    public UUID getId() {
        return id;
    }

    // Static method to create instance of MasterLion class
    public static MasterCrocodile getInstance()
    {
        if (single_instance == null)
            single_instance = new MasterCrocodile();

        return single_instance;
    }
}

