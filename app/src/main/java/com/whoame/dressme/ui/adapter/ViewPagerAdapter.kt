package com.whoame.dressme.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment = mFragmentList[position]

    override fun getCount(): Int = mFragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = mFragmentTitleList[position]

    override fun getItemPosition(`object`: Any?): Int {

        var position = super.getItemPosition(`object`)
        if (position >= 0)
            return position
        else return PagerAdapter.POSITION_NONE

    }

    fun addFragment(fragment: Fragment, title: String) {

        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)

    }

    fun setNewFragment(fragment: Fragment, position: Int) {

        mFragmentList[position] = fragment
        notifyDataSetChanged()

    }

}
