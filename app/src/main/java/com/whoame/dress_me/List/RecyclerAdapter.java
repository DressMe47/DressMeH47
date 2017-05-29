package com.whoame.dress_me.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.whoame.dress_me.JsonSchem.ModelItem;
import com.whoame.dress_me.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<ModelItem> modelItem = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(ArrayList arrayList, Context context){
        this.context = context;
        this.modelItem = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new RecyclerViewHolder(view);
    }

    //// FIXME: 26.05.2017 Работает, но нужно в нормальный вид привести....
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final ModelItem modelItem = this.modelItem.get(position);
        if (modelItem.getStatus() != -1) {

            //тут загрузка текста и фото и заполняет картинками и текстом.
            holder.name.setText(modelItem.getName());
            //// TODO: 16.05.2017 Перенести загрузку картинок в отдельный класс
            Picasso.with(context).load(modelItem.getImage()).into(holder.image);
        } else {
            holder.name.setText(R.string.fragment_contact_text);
        }
    }

    @Override
    public int getItemCount() {
        return modelItem.size();
    }
}