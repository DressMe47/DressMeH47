package com.whoame.dressme.dagger.modules

import com.whoame.dressme.model.Database
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase() = Database()

}