package com.whoame.dress_me.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.whoame.dress_me.JsonSchem.ModelItem;
import com.whoame.dress_me.JsonSchem.PostModel;
import com.whoame.dress_me.List.RecyclerAdapter;
import com.whoame.dress_me.List.RecyclerClickListener;
import com.whoame.dress_me.NetWork.App;
import com.whoame.dress_me.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.whoame.dress_me.Constans.ID_SELECTED;
import static com.whoame.dress_me.Constans.ID_SELECTED_DEFAULT;

public class FragmentProductsList extends Fragment {

    private ArrayList<ModelItem> modelItems = new ArrayList<ModelItem>();
    private GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
    private RecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        // Получим индекс, если имеется
        Bundle args = getArguments();
        Integer parentId = args != null ? args.getInt(ID_SELECTED, ID_SELECTED_DEFAULT) : ID_SELECTED_DEFAULT;

        // Если индекс обнаружен, то используем его
        if (parentId != ID_SELECTED_DEFAULT)
            Toast.makeText(getActivity(), " Welcome!\n" + parentId, Toast.LENGTH_SHORT).show();

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setBackgroundColor(Color.WHITE);

        //// TODO: 20.05.2017 Изменить 107 на id полученные из прошлых фрагментов
        final List<PostModel> posts = new ArrayList<>();

        App.getApi().getProductsList(/*parentId*/107).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                Toast.makeText(getActivity(), " WAT!\n", Toast.LENGTH_SHORT).show();
                posts.addAll(response.body());
                int responseSize = posts.size();

                for (int i = 1; i <= responseSize; i++) {
                    String internetUrlImage = "http://dressme.lan143.ru" + posts.get(i-1).getImages().get(0).getImageSrc();
                    String internetNameProducts = posts.get(i-1).getName();
                    Integer internerIdProducts = posts.get(i-1).getIdText();
                    modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));
                }

                adapter = new RecyclerAdapter(modelItems, getActivity());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(getActivity(), " WAT?\n", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerClickListener(getActivity()) {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                listener.onButtonProductSelected(modelItems.get(position).getIdPosition());
            }
        });

        return rootView;
    }
}
