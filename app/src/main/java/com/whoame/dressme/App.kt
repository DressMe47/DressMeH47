package com.whoame.dressme

import android.app.Application
import com.whoame.dressme.dagger.AppComponent
import com.whoame.dressme.dagger.DaggerAppComponent
import com.whoame.dressme.dagger.modules.ApplicationModule
import com.whoame.dressme.util.SharedPreference
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        SharedPreference.init(this)
        Realm.init(this)

        val config = RealmConfiguration.Builder()
                .name("database")
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)

        appComponent = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}