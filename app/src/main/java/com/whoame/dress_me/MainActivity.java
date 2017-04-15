package com.whoame.dress_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

        if (sex.equals("women")) {
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
        Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
        String sex = JsonWork.getSex();
        Toast toast = Toast.makeText(getApplicationContext(),
                sex, Toast.LENGTH_SHORT);
        toast.show();

        intent.putExtra("sex", sex);

        switch (v.getId()) {
            case R.id.button_shoes: {

                startActivity(intent);
                break;
            }
            case R.id.button_clothes: {

                startActivity(intent);
                break;
            }
            case R.id.button_accessories: {

                startActivity(intent);
                break;
            }
        }
    }
}
