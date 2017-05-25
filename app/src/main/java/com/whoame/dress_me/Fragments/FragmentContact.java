package com.whoame.dress_me.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whoame.dress_me.R;

/**
 * Created by oprv2 on 23.05.2017.
 */

public class FragmentContact extends Fragment {
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sevedInstateState) {
       View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

       return rootView;
   }
}
