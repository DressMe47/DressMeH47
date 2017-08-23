package com.whoame.dressme.ui.fragment

import com.arellomobile.mvp.MvpAppCompatFragment
import android.support.v7.app.AppCompatActivity

open class BaseFragment : MvpAppCompatFragment() {

    open fun onBackPressed() = true

    open fun showArrowBack() {}

    open fun hideArrowBack() {

        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(false)

    }

    open fun stateArrowBack() : Boolean = false

}
