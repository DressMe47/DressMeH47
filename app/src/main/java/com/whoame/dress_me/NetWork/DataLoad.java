package com.whoame.dress_me.NetWork;

import android.widget.Toast;

import com.whoame.dress_me.JsonSchem.PostModel;
import com.whoame.dress_me.List.ModelItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by oprv2 on 16.05.2017.
 */

public class DataLoad {
    private ArrayList<ModelItem> modelItems = new ArrayList<ModelItem>();

    public ArrayList<ModelItem> LoadCategoriesAndProducts (int parentId) {
        final List<PostModel> posts = new ArrayList<>();

        App.getApi().getCategories(parentId).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.addAll(response.body());
                Integer sz = posts.size();

                try {
                    for (int i = 1; i <= sz; i++) {
                        String internetUrlImage = "https://yt3.ggpht.com/-v0soe-ievYE/AAAAAAAAAAI/AAAAAAAAAAA/OixOH_h84Po/s900-c-k-no-mo-rj-c0xffffff/photo.jpg";//"http://dressme.lan143.ru" + posts.get(i-1).getImages().get(0).getImageSrc();
                        String internetNameProducts = posts.get(i-1).getName();
                        modelItems.add(new ModelItem(internetUrlImage, internetNameProducts));
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                modelItems.add(null);
            }
        });

        return modelItems;
    }
}
