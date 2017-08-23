package com.whoame.dressme.presentation.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.whoame.dressme.presentation.presenter.BasePresenter
import com.whoame.dressme.presentation.view.MainActivityView

@InjectViewState
class MainActivityPresenter : BasePresenter<MainActivityView>() {

    override fun onFirstViewAttach() {

        super.onFirstViewAttach()
        Log.d(this::class.java.simpleName, "onFirstViewAttach: viewState 1 = $viewState")

    }

}