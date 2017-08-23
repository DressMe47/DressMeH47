package com.whoame.dressme.dagger.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.whoame.dressme.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun superGson(): Gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .serializeNulls()
            .create()

    @Provides
    @Singleton
    fun providesClient(): OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            //.authenticator(TokenAuthenticator())
            //.addInterceptor(TokenInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideCallAdapterFactory(): RxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient, callAdapterFactory: RxJavaCallAdapterFactory?): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addCallAdapterFactory(callAdapterFactory)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build()

}