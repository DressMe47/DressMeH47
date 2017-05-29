package com.whoame.dress_me.JsonSchem;

public class ModelItem {
    private Integer idPosition;
    private String name;
    private String image;
    private Integer status = 0;

    public ModelItem(String image, String name, Integer idPosition) {
        this.idPosition = idPosition;
        this.name = name;
        this.image = image;
    }

    public ModelItem(Integer status) {
        this.status = status;
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

    public Integer getStatus() {
        return status;
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

    public void setStatus(Integer status) {
        this.status = status;
    }
}