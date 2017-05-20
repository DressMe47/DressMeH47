package com.whoame.dress_me.NetWork;

import com.whoame.dress_me.JsonSchem.PostModel;
import com.whoame.dress_me.JsonSchem.ModelItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by oprv2 on 16.05.2017.
 */

//// FIXME: 20.05.2017 На данный момент не ипользуется, надо перенести работу с сетью в данный класс

public class DataLoad {
    public static List<PostModel> LoadProducts (int parentId) {
        final List<PostModel> posts = new ArrayList<>();

        App.getApi().getProducts(parentId).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                posts.add(null);
            }
        });

        return posts;
    }
}
