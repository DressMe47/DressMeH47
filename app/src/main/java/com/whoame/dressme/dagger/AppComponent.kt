package com.whoame.dressme.dagger

import com.whoame.dressme.dagger.modules.ApiModule
import com.whoame.dressme.dagger.modules.ApplicationModule
import com.whoame.dressme.dagger.modules.BottomMenuModule
import com.whoame.dressme.dagger.modules.DatabaseModule
import com.whoame.dressme.model.Database
import com.whoame.dressme.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApiModule::class, ApplicationModule::class, DatabaseModule::class, BottomMenuModule::class))
interface AppComponent{

    fun inject(target: Database)
    fun inject(target: MainActivity)

}