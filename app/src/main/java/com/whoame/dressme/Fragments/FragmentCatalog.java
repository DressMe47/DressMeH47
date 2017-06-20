package com.whoame.dressme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.whoame.dressme.List.ExpandableRecyclerView.OnChildClickListener;
import com.whoame.dressme.List.ExpandableRecyclerView.RecyclerExpandableAdapter;
import com.whoame.dressme.Models.ExpandableModel.Categories;
import com.whoame.dressme.Models.ExpandableModel.Sex;
import com.whoame.dressme.Models.Filter;
import com.whoame.dressme.Models.JsonSchema.Item;
import com.whoame.dressme.NetWork.App;
import com.whoame.dressme.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCatalog extends Fragment {
    private ArrayList<Categories> categoriesMen = new ArrayList<Categories>();
    private ArrayList<Categories> categoriesWomen = new ArrayList<Categories>();
    private ArrayList<Categories> categoriesUni = new ArrayList<Categories>();
    private LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    private RecyclerExpandableAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        Filter filter;
        GsonBuilder builder;
        final List<Item> posts = new ArrayList<>();
        Gson gson;
        final int[] flag = {0};

        final int[] callId = {68, 100, 107, 108, 109, 112, 113, 114, 115, 116, 117};
        for (int i = 0; i < callId.length; i++) {

            filter = new Filter();
            filter.parent_id = callId[i];

            builder = new GsonBuilder();
            gson = builder.create();

            App.getApi().getCategories(gson.toJson(filter)).enqueue(new Callback<List<Item>>() {
                @Override
                public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                    posts.addAll(response.body());
                    Log.w("пам", String.valueOf(posts.size()));
                    int responseSize = posts.size();

                    flag[0]++;

                    if (flag[0] == callId.length) {
                        for (int i = 1; i <= responseSize; i++) {
                            String internetTileCategories = posts.get(i - 1).getName();
                            String internetChId = posts.get(i-1).getId();
                            int gender = posts.get(i - 1).getGender();
                            if (gender == 0) {
                                categoriesUni.add(new Categories(internetTileCategories, internetChId));
                            } else if (gender == 1) {
                                categoriesMen.add(new Categories(internetTileCategories, internetChId));
                            } else categoriesWomen.add(new Categories(internetTileCategories, internetChId));
                        }

                        Sex uni = new Sex("https://cs7056.userapi.com/c638331/v638331814/3fcb8/gvHJvc22jEI.jpg", categoriesUni);
                        Sex men = new Sex("https://pp.userapi.com/c639616/v639616814/1d8ef/nePTvS0SELs.jpg", categoriesMen);
                        Sex women = new Sex("https://pp.userapi.com/c639616/v639616814/1d8f7/DF2GZkkPMx4.jpg", categoriesWomen);

                        final List<Sex> sexList = Arrays.asList(uni, men, women);

                        adapter = new RecyclerExpandableAdapter(getActivity(), sexList);
                        adapter.setChildClickListener(new OnChildClickListener() {
                            @Override
                            public boolean onChildClick(View v, int groupPosition, int childPosition, long id) {
                                OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                                listener.onButtonCategorySelected(Integer.parseInt(sexList.get(groupPosition).getChildList().get(childPosition).getChId()));

                                return true;
                            }
                        });

                        recyclerView.setAdapter(adapter);

                        ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progress_recycler_view);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<List<Item>> call, Throwable t) {
                    ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progress_recycler_view);
                    progressBar.setVisibility(View.INVISIBLE);

                    TextView textView = (TextView) rootView.findViewById(R.id.bad_text);
                    textView.setVisibility(View.VISIBLE);
                }
            });
        }

        return rootView;
    }
}
