package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterLion {
    private static MasterLion single_instance = null;
    private UUID id;
    private String specie;
    public Case house;

    private MasterLion()
    {
        id = UUID.randomUUID();
        specie = "Lion";
    }

    public UUID getId() {
        return id;
    }

    // Static method to create instance of MasterLion class
    public static MasterLion getInstance()
    {
        if (single_instance == null)
            single_instance = new MasterLion();

        return single_instance;
    }
}
