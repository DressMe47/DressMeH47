package com.whoame.dressme.ui.fragment

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.whoame.dressme.R
import com.whoame.dressme.presentation.presenter.FragmentMainPresenter
import com.whoame.dressme.presentation.view.FragmentMainView

class FragmentMain : BaseFragment(), FragmentMainView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var mainFragmentPresenter: FragmentMainPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) = inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


    }

    override fun setupViewPager(viewPager: ViewPager) {



    }

}