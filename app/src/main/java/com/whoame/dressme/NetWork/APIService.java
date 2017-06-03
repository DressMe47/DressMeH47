package com.whoame.dressme.NetWork;

import com.whoame.dressme.Models.JsonSchema.DetailedProduct.Product;
import com.whoame.dressme.Models.JsonSchema.Item;
import com.whoame.dressme.Models.JsonSchema.ProductList.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface APIService {
    @Headers("Content-type:application/json")
    @GET("products")
    Call<List<PostModel>> getData(@Query("sort") String resourceName);
    //http://dressme.local/api/products?sort={"id": "desc"}

    @Headers("Content-type:application/json")
    @GET("categories/{id}/random")
    Call<List<PostModel>> getRand(@Path("id") int id);

    @Headers("Content-type:application/json")
    @GET("categories/{id}/products")
    Call<List<PostModel>> getSort(@Path("id") int id);

    @POST("products/{id}/Like")
    Call<List<PostModel>> setLike(@Path("id") int id);

    @Streaming
    @Headers("Content-type:application/json")
    @GET("categories")
    Call<List<Item>> getCategories(@Query("filter") String paren_id);

    @Headers("Content-type:application/json")
    @GET("products/{id}/")
    Call<Product> getProduct(@Path("id") int id);
}

