package com.whoame.dress_me;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.whoame.dress_me.Fragments.FragmentCategories;
import com.whoame.dress_me.Fragments.FragmentContact;
import com.whoame.dress_me.Fragments.FragmentDrawer;
import com.whoame.dress_me.Fragments.FragmentEntrance;
import com.whoame.dress_me.Fragments.FragmentProduct;
import com.whoame.dress_me.Fragments.FragmentProductsList;
import com.whoame.dress_me.Fragments.OnSelectedButtonListener;

import static com.whoame.dress_me.Constans.CLOSE;
import static com.whoame.dress_me.Constans.ID_SELECTED;
import static com.whoame.dress_me.Constans.OPEN;

public class MainActivity extends AppCompatActivity implements OnSelectedButtonListener {
    private boolean drawerStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // начинаем транзакцию
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Создаем и добавляем первый фрагмент
        FragmentEntrance fragmentEntrance = new FragmentEntrance();
        //Создаем и добавляем второй фрагмент
        FragmentDrawer fragmentDrawer = new FragmentDrawer();
        fragmentTransaction.add(R.id.container, fragmentEntrance, "fragmentEntrance").add(R.id.main_container, fragmentDrawer, "fragmentDrawer");
        // Подтверждаем операцию
        fragmentTransaction.commit();
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

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
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

    @Override
    public void onButtonDrawerSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (position) {
            case 1:
                int count = fragmentManager.getBackStackEntryCount();
                while(count > 0){
                    fragmentManager.popBackStack();
                    count--;
                }
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
    }

    @Override
    public void onDrawerChangeStatus(boolean status) {
        if (status) {
            drawerStatus = OPEN;
        } else {
            drawerStatus = CLOSE;
        }
    }

    public void onBackPressed() {
        // Закрываем Navigation Drawer по нажатию системной кнопки "Назад" если он открыт
        if (drawerStatus) {
            //// TODO: 29.05.2017 Найти как закрыть Drawer в фрагменте
            //*result.closeDrawer();*/
        } else {
            if (getFragmentManager().getBackStackEntryCount() != 0) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }
}
