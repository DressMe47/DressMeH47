package com.whoame.dressme;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.whoame.dressme.Fragments.FragmentContact;
import com.whoame.dressme.Fragments.FragmentCatalog;
import com.whoame.dressme.Fragments.FragmentEntrance;
import com.whoame.dressme.Fragments.FragmentProduct;
import com.whoame.dressme.Fragments.FragmentProductsList;
import com.whoame.dressme.Fragments.OnSelectedButtonListener;

import static com.whoame.dressme.Constans.ID_SELECTED;

public class MainActivity extends AppCompatActivity implements OnSelectedButtonListener {
    Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer = new DrawerBuilder()
                .withActivity(this)
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
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Скрываем клавиатуру при открытии Navigation Drawer
                        InputMethodManager inputMethodManager = (InputMethodManager) MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(MainActivity.this.getCurrentFocus().getWindowToken(), 0);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        switch (position) {
                            case 1:
                                int count = fragmentManager.getBackStackEntryCount();
                                while (count > 0) {
                                    fragmentManager.popBackStack();
                                    count--;
                                }
                                break;
                            case 2:
                                FragmentEntrance fragmentEntrance = new FragmentEntrance();

                                fragmentTransaction.add(R.id.container, fragmentEntrance, "fragmentEntrance");
                                fragmentTransaction.addToBackStack(null);

                                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
                                fragmentTransaction.commit();
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                FragmentContact fragmentContact = new FragmentContact();
                                fragmentTransaction.add(R.id.container, fragmentContact, "fragmentContact");
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                break;
                        }

                        return false;
                    }
                })
                .build();

        // подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // начинаем транзакцию
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Создаем и добавляем первый фрагмент
        FragmentCatalog fragmentCatalog = new FragmentCatalog();
        fragmentTransaction.add(R.id.container, fragmentCatalog, "fragmentCatalog");
        // Подтверждаем операцию
        fragmentTransaction.commit();
    }

    public void onButtonCategorySelected(int idSelected) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentProductsList fragmentProductsList = new FragmentProductsList();

        Bundle args = new Bundle();
        args.putInt(ID_SELECTED, idSelected);
        fragmentProductsList.setArguments(args);

        fragmentTransaction.add(R.id.container, fragmentProductsList, "fragmentProductsList");
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        fragmentTransaction.commit();
    }

    @Override
    public void onButtonProductSelected(int idSelected) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentProduct fragmentProduct = new FragmentProduct();

        Bundle args = new Bundle();
        args.putInt(ID_SELECTED, idSelected);
        fragmentProduct.setArguments(args);

        fragmentTransaction.add(R.id.container, fragmentProduct, "fragmentProduct");
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        fragmentTransaction.commit();
    }

    public void onBackPressed() {
        // Закрываем Navigation Drawer по нажатию системной кнопки "Назад" если он открыт
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            if (getFragmentManager().getBackStackEntryCount() != 0) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }
}
