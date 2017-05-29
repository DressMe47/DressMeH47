package com.whoame.dress_me.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.whoame.dress_me.R;

import static com.whoame.dress_me.Constans.CLOSE;
import static com.whoame.dress_me.Constans.OPEN;

/**
 * Created by oprv2 on 29.05.2017.
 */

public class FragmentDrawer extends Fragment {
    private Drawer result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drawer, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        result = new DrawerBuilder()
                .withActivity(getActivity())
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(R.drawable.home),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_favorite).withIcon(R.drawable.star),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_login).withIcon(R.drawable.login),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(R.drawable.help),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(R.drawable.settings),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(R.drawable.phone).withIdentifier(1)
                )
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Скрываем клавиатуру при открытии Navigation Drawer
                        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                        listener.onDrawerChangeStatus(OPEN);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        listener.onDrawerChangeStatus(CLOSE);
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                        listener.onButtonDrawerSelected(position);
                        return false;
                    }
                })
                .build();

        return rootView;
    }
}
