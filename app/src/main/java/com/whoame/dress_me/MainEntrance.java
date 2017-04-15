package com.whoame.dress_me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainEntrance extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        final Button button_men = (Button) findViewById(R.id.button_men);
        final Button button_women = (Button) findViewById(R.id.button_women);

        button_men.setOnClickListener(this);
        button_women.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_men: {
                Intent intent = new Intent(MainEntrance.this, MainActivity.class);
                intent.putExtra("sex", "men");
                startActivity(intent);
                break;
            }
            case R.id.button_women: {
                Intent intent = new Intent(MainEntrance.this, MainActivity.class);
                intent.putExtra("sex", "women");
                startActivity(intent);
                break;
            }
        }
    }
}
