package com.whoame.dress_me;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oprv2 on 15.04.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl("http://www.umori.li/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();

        APIService myApiService = retrofit.create(APIService.class); //Создаем объект, при помощи которого будем выполнять зап
    }

    public static UmoriliApi getApi() {
        return umoriliApi;
    }
}
