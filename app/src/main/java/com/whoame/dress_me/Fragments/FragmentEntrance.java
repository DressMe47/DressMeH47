package com.whoame.dress_me.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.whoame.dress_me.List.ModelItem;
import com.whoame.dress_me.List.RecyclerAdapter;
import com.whoame.dress_me.List.RecyclerClickListener;
import com.whoame.dress_me.R;

import java.util.ArrayList;

public class FragmentEntrance extends Fragment {
    private ArrayList<ModelItem> modelItems = new ArrayList<ModelItem>();
    private RecyclerAdapter adapter;
    private LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_products, container, false);

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        String internetUrlImage = "https://pp.userapi.com/c639616/v639616814/1d8ef/nePTvS0SELs.jpg";
        String internetNameProducts = String.valueOf(R.string.activity_entrance_button_men);
        modelItems.add(new ModelItem(internetUrlImage, internetNameProducts));

        internetUrlImage = "https://pp.userapi.com/c639616/v639616814/1d8f7/DF2GZkkPMx4.jpg";
        internetNameProducts = String.valueOf(R.string.activity_entrance_button_women);
        modelItems.add(new ModelItem(internetUrlImage, internetNameProducts));

        adapter = new RecyclerAdapter(modelItems, getActivity());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerClickListener(getActivity()) {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                int buttonIndex = position;

                OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                listener.onButtonSelected(buttonIndex);
            }
        });

        return rootView;
    }

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }
}
