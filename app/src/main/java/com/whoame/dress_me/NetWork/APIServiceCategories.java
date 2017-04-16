package com.whoame.dress_me.NetWork;

import com.whoame.dress_me.JsonSchem.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by oprv2 on 16.04.2017.
 */

public interface APIServiceCategories {
    @Headers("Content-type:application/json")
    @GET("categories")
    Call<List<PostModel>> getData(@Query("filter") String resourceName);

}
