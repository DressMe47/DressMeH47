package com.whoame.dress_me.List;

public class ModelItem {

    private String image;
    private String name;

    public ModelItem(String image, String name){
        this.image = image;
        this.name = name;
    }

    public String getImage(){
        return image;
    }

    public String getName(){
        return name;
    }


    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

}