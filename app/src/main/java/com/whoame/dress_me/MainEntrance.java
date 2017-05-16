package com.whoame.dress_me;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.whoame.dress_me.Fragments.FragmentEntrance;

public class MainEntrance extends AppCompatActivity implements FragmentEntrance.OnSelectedButtonListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
    }

    @Override
    public void onButtonSelected(int buttonIndex) {
        // подключаем FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Получаем ссылку на второй фрагмент по ID
        /*FragmentCategories fragmentCategories = (FragmentCategories) fragmentManager.findFragmentById(R.id.fragment);*/

        Toast toast = Toast.makeText(getApplicationContext(),
                "Data " + String.valueOf(buttonIndex), Toast.LENGTH_SHORT);
        toast.show();
        // Выводим нужную информацию
        /*if (fragmentCategories != null)
            fragmentCategories.setDescription(buttonIndex);*/
    }
}
