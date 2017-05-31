package com.whoame.dress_me.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whoame.dress_me.Models.ModelItem;
import com.whoame.dress_me.List.RecyclerAdapter;
import com.whoame.dress_me.List.RecyclerClickListener;
import com.whoame.dress_me.R;

import java.util.ArrayList;

import static com.whoame.dress_me.Constans.ID_SELECTED;
import static com.whoame.dress_me.Constans.ID_SELECTED_DEFAULT;

public class FragmentCategories extends Fragment {

    private ArrayList<ModelItem> modelItems = new ArrayList<ModelItem>();
    private LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    private RecyclerAdapter adapter;

    private int idSelected;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        // Получим индекс, если имеется
        Bundle args = getArguments();
        idSelected = args != null ? args.getInt(ID_SELECTED,
                ID_SELECTED_DEFAULT) : ID_SELECTED_DEFAULT;

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //// TODO: 19.05.2017 Дождаться исправлений на бэкенде и сделать запрос к серверу для получения id категорий пола, картинки и названия
        //// This!

        //// TODO: 19.05.2017 Как будет добавленны фото на бэкенде для категорий исправить на нормальное добавление
        Integer internerIdProducts;
        String internetNameProducts;
        String internetUrlImage;
        switch (idSelected) {
            case 0:
            case 1:
                internetUrlImage = "https://cs7056.userapi.com/c638331/v638331814/3fc34/xTelI39jy0s.jpg";
                internetNameProducts = getString(R.string.categories_clothes);
                internerIdProducts = 0;
                modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));

                internetUrlImage = "https://cs7056.userapi.com/c638331/v638331814/3fc43/mpcHrc7uDLU.jpg";
                internetNameProducts = getString(R.string.categories_shoes);
                internerIdProducts = 0;
                modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));

                internetUrlImage = "https://cs7056.userapi.com/c638331/v638331814/3fc25/3eLBOVGREXc.jpg";
                internetNameProducts = getString(R.string.categories_accessories);
                internerIdProducts = 0;
                modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));
                break;
            case 2:
                internetUrlImage = "https://cs7056.userapi.com/c638331/v638331814/3fc3b/QTkc-uvQld0.jpg";
                internetNameProducts = getString(R.string.categories_clothes);
                internerIdProducts = 0;
                modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));

                internetUrlImage = "https://cs7056.userapi.com/c638331/v638331814/3fc4b/akebWg92gTE.jpg";
                internetNameProducts = getString(R.string.categories_shoes);
                internerIdProducts = 0;
                modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));

                internetUrlImage = "https://cs7056.userapi.com/c638331/v638331814/3fc2c/s3OlhgUXm84.jpg";
                internetNameProducts = getString(R.string.categories_accessories);
                internerIdProducts = 0;
                modelItems.add(new ModelItem(internetUrlImage, internetNameProducts, internerIdProducts));
                break;
            default:
                break;
        }

        adapter = new RecyclerAdapter(modelItems, getActivity());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerClickListener(getActivity()) {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                listener.onButtonCategorySelected(position);
            }
        });

        return rootView;
    }
}
