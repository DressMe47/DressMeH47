package com.whoame.dressme.Models.JsonSchema.DetailedProduct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.whoame.dressme.Models.JsonSchema.ProductList.Image;
import com.whoame.dressme.Models.JsonSchema.ProductList.Prop;

import java.util.List;

/**
 * Created by oprv2 on 03.06.2017.
 */

public class Product {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("category_id")
    @Expose
    private String categoryId;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("color")
    @Expose
    private String color;

    @SerializedName("brand")
    @Expose
    private String brand;

    @SerializedName("material")
    @Expose
    private String material;

    @SerializedName("images")
    @Expose
    private List<Image> images = null;

    @SerializedName("props")
    @Expose
    private List<Prop> props = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
