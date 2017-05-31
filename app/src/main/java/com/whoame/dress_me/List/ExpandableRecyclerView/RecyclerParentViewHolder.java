package com.whoame.dress_me.List.ExpandableRecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.squareup.picasso.Picasso;
import com.whoame.dress_me.Models.ExpandableModel.Sex;
import com.whoame.dress_me.R;

/**
 * Created by oprv2 on 31.05.2017.
 */

public class RecyclerParentViewHolder extends ParentViewHolder {
    public ImageView titleImageView;

    public RecyclerParentViewHolder(@NonNull View itemView) {
        super(itemView);

        titleImageView = (ImageView) itemView.findViewById(R.id.parent_list_item_title_image_view);
    }

    public void bind(@NonNull Sex sex) {
        Context context = titleImageView.getContext();
        Picasso.with(context).load(sex.getTitle()).into(titleImageView);
    }
}
