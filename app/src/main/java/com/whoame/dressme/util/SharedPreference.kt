package com.whoame.dressme.util

import android.content.Context
import com.whoame.dressme.BuildConfig.*

object SharedPreference {

    private val sharedPreferences by lazy { context?.getSharedPreferences(APPLICATION_ID, Context.MODE_PRIVATE) }
    private var context: Context? = null

    fun init(context: Context) {
        this.context = context
    }

    fun save(key: String, value: String?) = sharedPreferences?.edit()?.putString(key, value)?.apply()

    fun read(key: String) = sharedPreferences?.getString(key, null)

    fun clear(key: String) = sharedPreferences?.edit()?.remove(key)?.apply()
}