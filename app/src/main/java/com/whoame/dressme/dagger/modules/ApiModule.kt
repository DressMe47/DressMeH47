package com.whoame.dressme.dagger.modules

import com.whoame.dressme.network.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = arrayOf(RetrofitModule::class))
class ApiModule {

    @Provides
    @Singleton
    fun provideCVAnalytics(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

}