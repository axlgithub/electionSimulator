package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterGiraffe {
    private static MasterGiraffe single_instance = null;
    public Case house;
    private final UUID id;
    private final String species;

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
}
