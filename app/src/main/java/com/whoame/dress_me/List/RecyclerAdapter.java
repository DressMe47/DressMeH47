package com.whoame.dress_me.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.whoame.dress_me.JsonSchem.ModelItem;
import com.whoame.dress_me.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<ModelItem> modelItem = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(ArrayList arrayList, Context context){
        this.modelItem = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final ModelItem modelItem = this.modelItem.get(position);

        //// TODO: 16.05.2017 Перенести загрузку картинок в отдельный класс 
        //тут загрузка текста и фото и заполняет картинками и текстом.
        Picasso.with(context).load(modelItem.getImage()).into(holder.image);
        holder.name.setText(modelItem.getName());
    }

    @Override
    public int getItemCount() {
        return modelItem.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView image;

        //перечисляю вьюшки в конкретном итеме

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.r_name);
            image = (ImageView) itemView.findViewById(R.id.r_image);
        }
    }
}