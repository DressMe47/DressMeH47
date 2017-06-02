package com.whoame.dressme.Models.ExpandableModel;

/**
 * Created by oprv2 on 31.05.2017.
 */

public class Categories {
    private String name;
    private String chId;

    public Categories(String name, String chId) {
        this.name = name;
        this.chId = chId;
    }

    public String getName() {
        return this.name;
    }

    public String getChId() {
        return chId;
    }
}
