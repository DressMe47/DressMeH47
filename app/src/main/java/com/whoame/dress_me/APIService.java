package com.whoame.dress_me;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @POST("/list")
    Call<List<PostModel>> getData(@Query("name") String  resourceName);
}
