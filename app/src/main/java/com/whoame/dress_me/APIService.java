package com.whoame.dress_me;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by oprv2 on 15.04.2017.
 */

public interface APIService {

    @POST("/list")
    Call<List<PostModel>> getData(@);

}
