package com.whoame.dressme.presentation.view

import android.support.v4.view.ViewPager
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface MainActivityView : MvpView {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun setupViewPager(viewPager: ViewPager)

    fun getCurrentFragment(position: Int)

}