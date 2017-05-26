package com.whoame.dress_me.List;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whoame.dress_me.R;

/**
 * Created by oprv2 on 25.05.2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView idPosition;
    public TextView name;
    public ImageView image;

    //перечисляю вьюшки в конкретном итеме

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        idPosition = (TextView) itemView.findViewById(R.id.card_id);
        name = (TextView) itemView.findViewById(R.id.card_name);
        image = (ImageView) itemView.findViewById(R.id.card_image);
    }
}
