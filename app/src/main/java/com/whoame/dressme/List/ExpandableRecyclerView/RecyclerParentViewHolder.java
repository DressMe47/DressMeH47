package com.whoame.dressme.List.ExpandableRecyclerView;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.whoame.dressme.R;

/**
 * Created by oprv2 on 31.05.2017.
 */

public class RecyclerParentViewHolder extends ParentViewHolder {
    public ImageView titleImageView;

    public RecyclerParentViewHolder(@NonNull View itemView) {
        super(itemView);

        titleImageView = (ImageView) itemView.findViewById(R.id.parent_list_item_title_image_view);
    }
}
