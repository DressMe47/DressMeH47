package com.whoame.dressme.dagger.modules

import com.whoame.dressme.ui.adapter.BottomNavigationViewHelper
import dagger.Module
import dagger.Provides

@Module
class BottomMenuModule {

    @Provides
    fun provideBottomMenu() = BottomNavigationViewHelper()

}