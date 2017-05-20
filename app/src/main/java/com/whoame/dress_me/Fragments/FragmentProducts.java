package com.whoame.dress_me.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.whoame.dress_me.JsonSchem.ModelItem;
import com.whoame.dress_me.JsonSchem.PostModel;
import com.whoame.dress_me.List.RecyclerAdapter;
import com.whoame.dress_me.List.RecyclerClickListener;
import com.whoame.dress_me.NetWork.App;
import com.whoame.dress_me.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentProducts extends Fragment {

    private ArrayList<ModelItem> modelItems = new ArrayList<ModelItem>();
    private RecyclerAdapter adapter;
    private LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        /*// Получим индекс, если имеется
        Bundle args = getArguments();
        List<PostModel> posts = args != null ? args.getInt(RESPONSE_SELECTION, RESPONSE_SELECTION_DEFAULT) : RESPONSE_SELECTION_DEFAULT;

        // Если индекс обнаружен, то используем его
        if (sexSelection != SEX_SELECTION_DEFAULT)
            Toast.makeText(getActivity(), " Welcome!\n" + sexSelection + " " + categorySelection, Toast.LENGTH_SHORT).show();*/

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setBackgroundColor(Color.WHITE);

        //// TODO: 20.05.2017 Изменить 107 на id полученные из прошлых фрагментов
        final List<PostModel> posts = new ArrayList<>();/* = LoadProducts(107);

        if (posts != null) {
            int responseSize = posts.size();

            for (int i = 1; i <= responseSize; i++) {
                String internetUrlImage = "http://dressme.lan143.ru" + posts.get(i-1).getImages().get(0).getImageSrc();
                String internetNameProducts = posts.get(i-1).getName();
                modelItems.add(new ModelItem(internetUrlImage, internetNameProducts));
            }

            adapter = new RecyclerAdapter(modelItems, getActivity());
            recyclerView.setAdapter(adapter);
        } else {

        }*/
        App.getApi().getProducts(/*parentId*/107).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.addAll(response.body());
                int responseSize = posts.size();

                for (int i = 1; i <= responseSize; i++) {
                    String internetUrlImage = "http://dressme.lan143.ru" + posts.get(i-1).getImages().get(0).getImageSrc();
                    String internetNameProducts = posts.get(i-1).getName();
                    modelItems.add(new ModelItem(internetUrlImage, internetNameProducts));
                }

                adapter = new RecyclerAdapter(modelItems, getActivity());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                posts.add(null);
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerClickListener(getActivity()) {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                /*int categorySelection = position;

                OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                listener.onButtonProductSelected(categorySelection);*/
                Toast.makeText(getActivity(), " Welcome!\n" + position, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
