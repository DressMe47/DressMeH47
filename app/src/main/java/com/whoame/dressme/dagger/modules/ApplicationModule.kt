package com.whoame.dressme.dagger.modules

import com.whoame.dressme.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(application: App) {

    var application: App
        @Provides
        @Singleton
        get() = field

    init {
        this.application = application
    }

}