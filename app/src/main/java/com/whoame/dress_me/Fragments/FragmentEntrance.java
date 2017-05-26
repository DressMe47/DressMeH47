package com.whoame.dress_me.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whoame.dress_me.JsonSchem.ModelItem;
import com.whoame.dress_me.List.RecyclerAdapter;
import com.whoame.dress_me.List.RecyclerClickListener;
import com.whoame.dress_me.R;

import java.util.ArrayList;

public class FragmentEntrance extends Fragment {
    private ArrayList<ModelItem> modelItems = new ArrayList<ModelItem>();
    private LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    private RecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        Integer internerIdProducts;
        String internetNameProducts;
        String internetUrlImage;

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setBackgroundColor(Color.WHITE);

        internetUrlImage = "https://cs7056.userapi.com/c638331/v638331814/3fcb8/gvHJvc22jEI.jpg";
        internetNameProducts = getString(R.string.sex_unisex);
        internerIdProducts = 0;
        modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));

        internetUrlImage = "https://pp.userapi.com/c639616/v639616814/1d8ef/nePTvS0SELs.jpg";
        internetNameProducts = getString(R.string.sex_men);
        internerIdProducts = 0;
        modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));

        internetUrlImage = "https://pp.userapi.com/c639616/v639616814/1d8f7/DF2GZkkPMx4.jpg";
        internetNameProducts = getString(R.string.sex_women);
        internerIdProducts = 0;
        modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));

        adapter = new RecyclerAdapter(modelItems, getActivity());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerClickListener(getActivity()) {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                listener.onButtonSexSelected(position);
            }
        });

        return rootView;
    }
}
