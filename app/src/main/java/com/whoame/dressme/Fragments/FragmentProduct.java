package com.whoame.dressme.Fragments;

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
import com.whoame.dressme.Models.JsonSchema.DetailedProduct.Product;
import com.whoame.dressme.Models.JsonSchema.ProductList.PostModel;
import com.whoame.dressme.NetWork.App;
import com.whoame.dressme.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.whoame.dressme.Constans.ID_SELECTED;
import static com.whoame.dressme.Constans.ID_SELECTED_DEFAULT;

/**
 * Created by oprv2 on 28.05.2017.
 */

public class FragmentProduct extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_product, container, false);

        Bundle args = getArguments();
        Integer selectedId = args != null ? args.getInt(ID_SELECTED, ID_SELECTED_DEFAULT) : ID_SELECTED_DEFAULT;

        final Product posts = new Product();

        App.getApi().getProduct(78).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                /*posts = (response.body());
                int responseSize = posts.size();*/

                try {

                    ImageView imageView = (ImageView) rootView.findViewById(R.id.fragment_product_image);
                    Picasso.with(getActivity()).load("http://dressme.lan143.ru" + response.body().getImages().get(0).getImageSrc()).into(imageView);

                    TextView textViewName = (TextView) rootView.findViewById(R.id.fragment_product_name);
                    textViewName.setText(posts.getName());

                    TextView textViewBrand = (TextView) rootView.findViewById(R.id.fragment_product_brand);
                    textViewBrand.setText(posts.getBrand());

                    TextView textViewPrice = (TextView) rootView.findViewById(R.id.fragment_product_price);
                    textViewPrice.setText(posts.getPrice());

                    TextView textViewMaterial = (TextView) rootView.findViewById(R.id.fragment_product_material);
                    textViewMaterial.setText(posts.getMaterial());
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage() + "\n" + posts.getName() + posts.getBrand() + posts.getPrice() + posts.getMaterial()/*responseSize*/, Toast.LENGTH_LONG).show();
                    Log.w("Log", "Перехват" + e);
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
            }
        });

        return rootView;
    }
}
