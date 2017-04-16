package com.whoame.dress_me;
// 107 108 2
//
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.whoame.dress_me.JsonSchem.JsonWork;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainClothesActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clothes);

        final ImageView button_up = (ImageView) findViewById(R.id.button_up);
        final ImageView button_down = (ImageView) findViewById(R.id.button_down);

        Intent intent = getIntent();
        String sex = intent.getStringExtra("sex");

        JsonWork.setSex(sex);

        if (sex.equals("2")) {
            button_up.setImageResource(R.drawable.up_w);
            button_down.setImageResource(R.drawable.down_w);
        } else {
            button_up.setImageResource(R.drawable.up_m);
            button_down.setImageResource(R.drawable.down_m);
        }

        button_up.setOnClickListener(this);
        button_down.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_up: {
                Intent intent = new Intent(MainClothesActivity.this, ProductsActivity.class);
                intent.putExtra("Category", 107);
                startActivity(intent);
                break;
            }
            case R.id.button_down: {
                Intent intent = new Intent(MainClothesActivity.this, ProductsActivity.class);
                intent.putExtra("Category", 108);
                startActivity(intent);
                break;
            }
        }
    }
}
