package com.whoame.dressme.ui.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.whoame.dressme.App
import com.whoame.dressme.R
import com.whoame.dressme.presentation.presenter.MainActivityPresenter
import com.whoame.dressme.presentation.view.MainActivityView
import com.whoame.dressme.ui.adapter.BottomNavigationViewHelper
import com.whoame.dressme.ui.adapter.ViewPagerAdapter
import com.whoame.dressme.ui.fragment.BaseFragment
import com.whoame.dressme.ui.fragment.FragmentMain
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainActivityView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var presenter: MainActivityPresenter

    @Inject
    lateinit var menuHelper: BottomNavigationViewHelper

    var mainAdapter =  ViewPagerAdapter(supportFragmentManager)
    var currentFragment: BaseFragment? = null

    init {
        App.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)

        setupViewPager(main_viewpager)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        menuHelper.disableShiftMode(menu_bottom_navigation)
        menu_bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_main -> main_viewpager.currentItem = 0
                R.id.action_trends -> main_viewpager.currentItem = 1
                R.id.action_catalog -> main_viewpager.currentItem = 2
                R.id.action_for_you -> main_viewpager.currentItem = 3
                R.id.action_profile -> main_viewpager.currentItem = 4
            }
            false
        }
        main_viewpager.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {



            }

            override fun onPageSelected(position: Int) {

                menu_bottom_navigation.menu.getItem(position).isChecked = true

            }

            override fun onPageScrollStateChanged(state: Int) {



            }

        })

    }

    override fun setupViewPager(viewPager: ViewPager) {

        mainAdapter.addFragment(FragmentMain(), getString(R.string.bottom_navigation_main))
        /*mainAdapter.addFragment(TrendsFragment(), getString(R.string.bottom_navigation_trends))
        mainAdapter.addFragment(CatalogFragment(), getString(R.string.bottom_navigation_catalog))
        mainAdapter.addFragment(ForYouFragment(), getString(R.string.bottom_navigation_for_you))
        mainAdapter.addFragment(ProfileFragment(), getString(R.string.bottom_navigation_profile))
        viewPager.adapter = mainAdapter*/

    }

    override fun getCurrentFragment(position: Int) {

        currentFragment = mainAdapter.getItem(position) as BaseFragment

    }

    override fun onBackPressed() {

        if (currentFragment!!.onBackPressed())
            super.onBackPressed()

    }

}