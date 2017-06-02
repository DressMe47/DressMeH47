package com.whoame.dressme.List.ExpandableRecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.squareup.picasso.Picasso;
import com.whoame.dressme.Models.ExpandableModel.Categories;
import com.whoame.dressme.Models.ExpandableModel.Sex;
import com.whoame.dressme.R;

import java.util.List;

/**
 * Created by oprv2 on 31.05.2017.
 */

public class RecyclerExpandableAdapter extends ExpandableRecyclerAdapter<Sex, Categories, RecyclerParentViewHolder, RecyclerChildViewHolder> {
    private LayoutInflater inflater;
    List<Sex> sexList;
    OnChildClickListener childClickListener;

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
        Picasso.with(parentViewHolder.titleImageView.getContext()).load(sexList.get(parentPosition).getTitle()).into(parentViewHolder.titleImageView);
    }

    @Override
    public void onBindChildViewHolder(@NonNull RecyclerChildViewHolder childViewHolder, final int parentPosition, final int childPosition, @NonNull Categories child) {
        childViewHolder.titleTextView.setText(sexList.get(parentPosition).getChildList().get(childPosition).getName());
        childViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public int getChildAdapterPosition() {
                return childPosition;
            }

            public int getParentAdapterPosition() {
                return parentPosition;
            }

            @Override
            public void onClick(View itemView) {
                if (childClickListener != null) {
                    childClickListener.onChildClick(itemView, getParentAdapterPosition(), getChildAdapterPosition(), 0);
                }
            }
        });
    }

    //// TODO: 02.06.2017 Вынести обработчик кликов в отдельный клас и передать по виду обработчика обычного RecyclerView
    public void setChildClickListener(OnChildClickListener clickListener) {
        this.childClickListener = clickListener;
    }
}
