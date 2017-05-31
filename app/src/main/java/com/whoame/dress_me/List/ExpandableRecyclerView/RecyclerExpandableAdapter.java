package com.whoame.dress_me.List.ExpandableRecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.whoame.dress_me.Models.ExpandableModel.Categories;
import com.whoame.dress_me.Models.ExpandableModel.Sex;
import com.whoame.dress_me.R;

import java.util.List;

/**
 * Created by oprv2 on 31.05.2017.
 */

public class RecyclerExpandableAdapter extends ExpandableRecyclerAdapter<Sex, Categories, RecyclerParentViewHolder, RecyclerChildViewHolder> {
    private LayoutInflater inflater;
    private List<Sex> sexList;

    public RecyclerExpandableAdapter(Context context, @NonNull List<Sex> parentList) {
        super(parentList);

        sexList = parentList;
        inflater = LayoutInflater.from(context);
    }

    @UiThread
    @NonNull
    @Override
    public RecyclerParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View sexView;

        sexView = inflater.inflate(R.layout.recycler_list_item_parent, parentViewGroup, false);
        return new RecyclerParentViewHolder(sexView);
    }

    @UiThread
    @NonNull
    @Override
    public RecyclerChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View childView;

        childView = inflater.inflate(R.layout.recycler_list_item_child, childViewGroup, false);
        return new RecyclerChildViewHolder(childView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull RecyclerParentViewHolder parentViewHolder, int parentPosition, @NonNull Sex parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull RecyclerChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Categories child) {
        childViewHolder.bind(child);
    }
}
