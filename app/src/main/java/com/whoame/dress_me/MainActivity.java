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

        final Button button_first = (Button) findViewById(R.id.button_shoes);
        final Button button_second = (Button) findViewById(R.id.button_clothes);
        final Button button_third = (Button) findViewById(R.id.button_accessories);

        Intent intent = getIntent();
        String sex = intent.getStringExtra("sex");

        if (sex.equals("women")) {
            button_first.setBackgroundResource(R.drawable.shoes_w);
            button_second.setBackgroundResource(R.drawable.close_w);
            button_third.setBackgroundResource(R.drawable.accessories_w);
        } else {
            button_first.setBackgroundResource(R.drawable.shoes_m);
            button_second.setBackgroundResource(R.drawable.close_m);
            button_third.setBackgroundResource(R.drawable.accessories_m);
        }

        /*Toast toast = Toast.makeText(getApplicationContext(),
                sex, Toast.LENGTH_SHORT);
        toast.show();*/

        button_first.setOnClickListener(this);
        button_second.setOnClickListener(this);
        button_third.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
        String sex;
        Toast toast = Toast.makeText(getApplicationContext(),
                findViewById(R.id.button_shoes).getBackground().toString(), Toast.LENGTH_SHORT);
        toast.show();

        if (findViewById(R.id.button_shoes).getBackground().toString().equals("shoes_w")) {
            intent.putExtra("sex", "women");
            sex = "women";
        } else {
            intent.putExtra("sex", "men");
            sex = "men";
        }

        switch (v.getId()) {
            case R.id.button_shoes: {
                /*Toast toast = Toast.makeText(getApplicationContext(),
                        sex, Toast.LENGTH_SHORT);
                toast.show();*/
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
