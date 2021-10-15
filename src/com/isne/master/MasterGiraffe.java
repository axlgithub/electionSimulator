package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterGiraffe {
    private static MasterGiraffe single_instance = null;
    private UUID id;
    private String specie;
    public Case house;

    private MasterGiraffe()
    {
        id = UUID.randomUUID();
        specie = "Giraffe";
    }

    public UUID getId() {
        return id;
    }

    // Static method to create instance of MasterLion class
    public static MasterGiraffe getInstance()
    {
        if (single_instance == null)
            single_instance = new MasterGiraffe();

        return single_instance;
    }
}
