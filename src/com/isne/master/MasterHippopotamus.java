package com.isne.master;

import com.isne.board.Case;

import java.util.UUID;

public class MasterHippopotamus {
    private static MasterHippopotamus single_instance = null;
    private UUID id;
    private String specie;
    public Case house;

    private MasterHippopotamus()
    {
        id = UUID.randomUUID();
        specie = "Hippopotamus";
    }

    public UUID getId() {
        return id;
    }

    // Static method to create instance of MasterLion class
    public static MasterHippopotamus getInstance()
    {
        if (single_instance == null)
            single_instance = new MasterHippopotamus();

        return single_instance;
    }
}
