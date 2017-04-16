package com.whoame.dress_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.whoame.dress_me.JsonSchem.JsonWork;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView button_first = (ImageView) findViewById(R.id.button_shoes);
        final ImageView button_second = (ImageView) findViewById(R.id.button_clothes);
        final ImageView button_third = (ImageView) findViewById(R.id.button_accessories);

        Intent intent = getIntent();
        String sex = intent.getStringExtra("sex");

        JsonWork.setSex(sex);

        if (sex.equals("2")) {
            button_first.setImageResource(R.drawable.shoes_w);
            button_second.setImageResource(R.drawable.close_w);
            button_third.setImageResource(R.drawable.accessories_w);
        } else {
            button_first.setImageResource(R.drawable.shoes_m);
            button_second.setImageResource(R.drawable.close_m);
            button_third.setImageResource(R.drawable.accessories_m);
        }

        button_first.setOnClickListener(this);
        button_second.setOnClickListener(this);
        button_third.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String sex = JsonWork.getSex();

        switch (v.getId()) {
            case R.id.button_shoes: {
                Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
                intent.putExtra("sex", sex);
                if (sex.equals("1")) {
                    intent.putExtra("Category", 37);
                } else {
                    intent.putExtra("Category", 34);
                }
                startActivity(intent);
                break;
            }
            case R.id.button_clothes: {
                Intent intent = new Intent(MainActivity.this, MainClothesActivity.class);
                intent.putExtra("sex", sex);
                if (sex.equals("1")) {
                    intent.putExtra("Category", 36);
                } else {
                    intent.putExtra("Category", 33);
                }
                startActivity(intent);
                break;
            }
            case R.id.button_accessories: {
                Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
                intent.putExtra("sex", sex);
                if (sex.equals("1")) {
                    intent.putExtra("Category", 38);
                } else {
                    intent.putExtra("Category", 35);
                }
                startActivity(intent);
                break;
            }
        }
    }
}
