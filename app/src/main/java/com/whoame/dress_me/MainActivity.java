package com.whoame.dress_me;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.whoame.dress_me.Fragments.FragmentCategories;
import com.whoame.dress_me.Fragments.FragmentContact;
import com.whoame.dress_me.Fragments.FragmentEntrance;
import com.whoame.dress_me.Fragments.FragmentProductsList;
import com.whoame.dress_me.Fragments.OnSelectedButtonListener;

import static com.whoame.dress_me.Constans.ID_SELECTED;

public class MainActivity extends AppCompatActivity implements OnSelectedButtonListener {
    private Drawer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        result = new DrawerBuilder()
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
                                fragmentManager.popBackStack();
                                break;
                            case 2:
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
        FragmentEntrance fragmentEntrance = new FragmentEntrance();
        fragmentTransaction.add(R.id.container, fragmentEntrance, "fragmentEntrance");
        // Подтверждаем операцию
        fragmentTransaction.commit();
    }

    public void onBackPressed() {
        // Закрываем Navigation Drawer по нажатию системной кнопки "Назад" если он открыт
        if (result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            int count = fragmentManager.getBackStackEntryCount();

            if (count != 0) {
                while(count > 0){
                    fragmentManager.popBackStack();
                    count--;
                }
            } else {
                super.onBackPressed();

            }
        }
    }

    public void onButtonSexSelected(int idSelected) {
        // подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // начинаем транзакцию
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentCategories fragmentCategories = new FragmentCategories();

        // Подготавливаем аргументы
        Bundle args = new Bundle();
        args.putInt(ID_SELECTED, idSelected);
        fragmentCategories.setArguments(args);

        fragmentTransaction.add(R.id.container, fragmentCategories, "fragmentCategories");
        fragmentTransaction.addToBackStack(null);

        // TODO: 18.05.2017 сделать кастомную анимацию
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        // ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.commit();
    }

    public void onButtonCategorySelected(int idSelected) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentProductsList fragmentProductsList = new FragmentProductsList();

        Bundle args = new Bundle();
        args.putInt(ID_SELECTED,idSelected);
        fragmentProductsList.setArguments(args);

        fragmentTransaction.add(R.id.container, fragmentProductsList, "fragmentProductsList");
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        fragmentTransaction.commit();
    }

    @Override
    public void onButtonProductSelected(int index) {
        Toast.makeText(getApplicationContext(), " Welcome!\n" + index, Toast.LENGTH_SHORT).show();
    }
}
