package com.whoame.dress_me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.whoame.dress_me.JsonSchem.PostModel;
import com.whoame.dress_me.List.ModelItem;
import com.whoame.dress_me.List.RecyclerAdapter;
import com.whoame.dress_me.List.RecyclerClickListener;
import com.whoame.dress_me.NetWork.App;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {
    private ArrayList<ModelItem> modelItems = new ArrayList<ModelItem>();
    private RecyclerAdapter adapter;
    private LinearLayoutManager layoutManager = new LinearLayoutManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        final Intent intent = getIntent();
        Integer category = intent.getIntExtra("Category", 107);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        final List<PostModel> posts = new ArrayList<>();

        App.getApi().getSort(category).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.addAll(response.body());

                Integer sz = posts.size();

                try {
                    for (int i = 1; i <= sz; i++) {
                        String internetUrlImage = "http://dressme.lan143.ru" + posts.get(i-1).getImages().get(0).getImageSrc();
                        String internetNameProducts = posts.get(i-1).getName();
                        modelItems.add(new ModelItem(internetUrlImage, internetNameProducts));
                    }

                    adapter = new RecyclerAdapter(modelItems, ProductsActivity.this);
                    recyclerView.setAdapter(adapter);
                } catch (Throwable e) {
                    e.printStackTrace();
                    Toast toast2 = Toast.makeText(getApplicationContext(), "404", Toast.LENGTH_SHORT);
                    toast2.show();
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Data empty", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerClickListener(ProductsActivity.this) {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Data", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView,
                                    int position) {
                /*App.getApi().setLike(0).enqueue(new Callback<List<PostModel>>() {
                    @Override
                    public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                        posts.addAll(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<PostModel>> call, Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Data empty", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });*/
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Data", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
