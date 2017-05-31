package com.whoame.dress_me.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.whoame.dress_me.Models.JsonSchema.PostModel;
import com.whoame.dress_me.NetWork.App;
import com.whoame.dress_me.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.whoame.dress_me.Constans.ID_SELECTED;
import static com.whoame.dress_me.Constans.ID_SELECTED_DEFAULT;

/**
 * Created by oprv2 on 28.05.2017.
 */

public class FragmentProduct extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_product, container, false);

        Bundle args = getArguments();
        Integer selectedId = args != null ? args.getInt(ID_SELECTED, ID_SELECTED_DEFAULT) : ID_SELECTED_DEFAULT;

        final List<PostModel> posts = new ArrayList<>();

        App.getApi().getProduct(78).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posts.addAll(response.body());
                int responseSize = posts.size();

                Toast.makeText(getActivity(), " WAT?\n" + responseSize, Toast.LENGTH_SHORT).show();

                try {

                    ImageView imageView = (ImageView) rootView.findViewById(R.id.fragment_product_image);
                    Picasso.with(getActivity()).load("http://dressme.lan143.ru" + posts.get(0).getImages()).into(imageView);

                    TextView textViewName = (TextView) rootView.findViewById(R.id.fragment_product_name);
                    textViewName.setText(posts.get(0).getName());

                    TextView textViewBrand = (TextView) rootView.findViewById(R.id.fragment_product_brand);
                    textViewBrand.setText(posts.get(0).getBrand());

                    TextView textViewPrice = (TextView) rootView.findViewById(R.id.fragment_product_price);
                    textViewPrice.setText(posts.get(0).getPrice().toString());

                    TextView textViewDescription = (TextView) rootView.findViewById(R.id.fragment_product_description);
                    textViewDescription.setText(posts.get(0).getDescription());
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage() + "\n" + responseSize, Toast.LENGTH_LONG).show();
                    Log.w("Log", "Перехват" + e);
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(getActivity(), " WAT?\n", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
