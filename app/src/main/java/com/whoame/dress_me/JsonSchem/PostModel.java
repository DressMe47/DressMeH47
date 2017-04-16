package com.whoame.dress_me.JsonSchem;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("price")
    @Expose
    private Object price;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("color")
    @Expose
    private Object color;
    @SerializedName("brand")
    @Expose
    private Object brand;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("props")
    @Expose
    private List<Prop> props = null;

    public Integer getIdText() {
        return id;
    }

    public void setIdText(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public Object getBrand() {
        return brand;
    }

    public void setBrand(Object brand) {
        this.brand = brand;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Prop> getProps() {
        return props;
    }

    public void setProps(List<Prop> props) {
        this.props = props;
    }

}
