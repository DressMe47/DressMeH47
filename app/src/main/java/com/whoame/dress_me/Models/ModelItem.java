package com.whoame.dress_me.Models;

public class ModelItem {
    private Integer idPosition;
    private String name;
    private String image;

    public ModelItem(String image, String name, Integer idPosition) {
        this.idPosition = idPosition;
        this.name = name;
        this.image = image;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }
}