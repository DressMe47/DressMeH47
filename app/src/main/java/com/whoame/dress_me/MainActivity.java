package com.whoame.dress_me;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.whoame.dress_me.Fragments.FragmentCategories;
import com.whoame.dress_me.Fragments.FragmentEntrance;
import com.whoame.dress_me.Fragments.FragmentProducts;
import com.whoame.dress_me.Fragments.OnSelectedButtonListener;

import java.util.ArrayList;

import static com.whoame.dress_me.Constans.RESPONSE_SELECTION;
import static com.whoame.dress_me.Constans.SEX_SELECTION;

public class MainActivity extends AppCompatActivity implements OnSelectedButtonListener {
    public int sexSelectionActivity;
    public int categorySelectionActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        // подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // начинаем транзакцию
        FragmentTransaction ft = fragmentManager.beginTransaction();
        // Создаем и добавляем первый фрагмент
        FragmentEntrance fragmentEntrance = new FragmentEntrance();
        ft.add(R.id.container, fragmentEntrance, "fragmentEntrance");
        // Подтверждаем операцию
        ft.commit();
    }

    public void onButtonSexSelected(int sexSelection) {
        // подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // начинаем транзакцию
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentCategories fragmentCategories = new FragmentCategories();

        sexSelectionActivity = sexSelection;

        // Подготавливаем аргументы
        Bundle args = new Bundle();
        args.putInt(SEX_SELECTION, sexSelection);
        fragmentCategories.setArguments(args);

        fragmentTransaction.add(R.id.container, fragmentCategories, "fragmentCategories");
        fragmentTransaction.addToBackStack(null);

        // TODO: 18.05.2017 сделать кастомную анимацию
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        // ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.commit();
    }

    public void onButtonCategorySelected(int categorySelection) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentProducts fragmentProducts = new FragmentProducts();

        /*Bundle args = new Bundle();*/
        /*args.putParcelableArrayList(RESPONSE_SELECTION, (ArrayList<? extends Parcelable>) posts);*/
        /*fragmentProducts.setArguments(args);*/

        fragmentTransaction.add(R.id.container, fragmentProducts, "fragmentProducts");
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        fragmentTransaction.commit();
    }

    @Override
    public void onButtonProductSelected(int index) {

    }
}
