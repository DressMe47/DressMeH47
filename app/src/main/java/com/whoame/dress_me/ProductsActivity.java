package com.whoame.dress_me;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        final List<PostModel> posts = new ArrayList<>();

        App.getApi().getData("{\"id\": \"desc\"}").enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                /*posts.addAll(response.body());
                final TextView button_first = (TextView) findViewById(R.id.text_json);

                button_first.setText(posts.toString());
*/
                Toast toast = Toast.makeText(getApplicationContext(),
                        "hueta" + posts, Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        JsonWork.getSex(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
