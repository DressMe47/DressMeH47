package com.whoame.dressme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whoame.dressme.List.ViewPager.ViewPagerAdapter;
import com.whoame.dressme.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentEntrance extends Fragment {
    ViewPager viewPager;
    List<String> images = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_entrance, container, false);

        viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());

        //// TODO: 20.06.2017 Временная заглушка
        images.add("https://pp.userapi.com/c639327/v639327814/4882f/wnYpUG043rs.jpg");
        images.add("https://pp.userapi.com/c639327/v639327814/48839/zaGvPfy3pHo.jpg");
        images.add("https://pp.userapi.com/c639327/v639327814/48843/t4RGqGiDjC8.jpg");
        images.add("https://pp.userapi.com/c639327/v639327814/4884d/EorAIGkjLlQ.jpg");


        viewPagerAdapter.setImages(images);
        viewPager.setAdapter(viewPagerAdapter);

        return rootView;
    }
}
