package com.whoame.dress_me.Fragments;

import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.whoame.dress_me.List.ExpandableRecyclerView.RecyclerExpandableAdapter;
import com.whoame.dress_me.Models.ExpandableModel.Categories;
import com.whoame.dress_me.Models.ExpandableModel.Sex;
import com.whoame.dress_me.Models.ModelItem;
import com.whoame.dress_me.List.RecyclerAdapter;
import com.whoame.dress_me.List.RecyclerClickListener;
import com.whoame.dress_me.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentEntrance extends Fragment {
    private ArrayList<ModelItem> modelItems = new ArrayList<ModelItem>();
    private LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    private RecyclerExpandableAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        Integer internerIdProducts;
        String internetNameProducts;
        String internetUrlImage;

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        Categories beef = new Categories("beef");
        Categories cheese = new Categories("cheese");
        Categories salsa = new Categories("salsa");
        Categories tortilla = new Categories("tortilla");
        Categories ketchup = new Categories("ketchup");
        Categories bun = new Categories("bun");

        Sex taco = new Sex("https://cs7056.userapi.com/c638331/v638331814/3fcb8/gvHJvc22jEI.jpg", Arrays.asList(beef, cheese, salsa, tortilla));
        Sex quesadilla = new Sex("https://pp.userapi.com/c639616/v639616814/1d8ef/nePTvS0SELs.jpg", Arrays.asList(cheese, tortilla));
        Sex burger = new Sex("https://pp.userapi.com/c639616/v639616814/1d8f7/DF2GZkkPMx4.jpg", Arrays.asList(beef, cheese, ketchup, bun));
        final List<Sex> sexList = Arrays.asList(taco, quesadilla, burger);

        adapter = new RecyclerExpandableAdapter(getActivity(), sexList);
        adapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @UiThread
            @Override
            public void onParentExpanded(int parentPosition) {
                Sex expandedRecipe = sexList.get(parentPosition);

                Toast.makeText(getActivity(), "++\n++", Toast.LENGTH_SHORT)
                        .show();
            }

            @UiThread
            @Override
            public void onParentCollapsed(int parentPosition) {
                Sex collapsedRecipe = sexList.get(parentPosition);

                Toast.makeText(getActivity(), "--\n--",  Toast.LENGTH_SHORT).show();
            }
        });

        /*internetUrlImage = "https://cs7056.userapi.com/c638331/v638331814/3fcb8/gvHJvc22jEI.jpg";
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
        modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));*/

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
