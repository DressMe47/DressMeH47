package com.whoame.dressme.presentation.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.whoame.dressme.presentation.view.FragmentMainView

@InjectViewState
class FragmentMainPresenter : BasePresenter<FragmentMainView>() {

    override fun onFirstViewAttach() {

        super.onFirstViewAttach()
        Log.d(this::class.java.simpleName, "onFirstViewAttach: viewState 1 = $viewState")

    }

}