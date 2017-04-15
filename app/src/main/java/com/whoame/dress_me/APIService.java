package com.whoame.dress_me;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    /*@Headers("Content type: application/json")
    */@GET("products")
    Call<List<PostModel>> getData(@Query("sort") String resourceName);
    //http://dressme.local/api/products?sort={"id": "desc"}
}
