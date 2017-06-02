package com.whoame.dressme.List.ExpandableRecyclerView;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.whoame.dressme.R;

/**
 * Created by oprv2 on 31.05.2017.
 */

public class RecyclerChildViewHolder extends ChildViewHolder {
    public TextView titleTextView;

    public RecyclerChildViewHolder(@NonNull View itemView) {
        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.child_list_item_name_text_view);
    }
}
