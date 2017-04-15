package com.whoame.dress_me;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        Toast toast = Toast.makeText(getApplicationContext(),
                JsonWork.getSex(), Toast.LENGTH_SHORT);
        toast.show();
    }
}
