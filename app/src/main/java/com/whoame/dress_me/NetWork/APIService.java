package com.whoame.dress_me.NetWork;

import com.whoame.dress_me.JsonSchem.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
}

