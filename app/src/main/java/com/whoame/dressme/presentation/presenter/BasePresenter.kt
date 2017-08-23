package com.whoame.dressme.presentation.presenter

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.whoame.dressme.util.simpleNetworkRequest
import rx.Observable
import rx.Subscription
import rx.subscriptions.CompositeSubscription

open class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    private val compositeSubscription = CompositeSubscription()

    protected fun unsubscribeOnDestroy(subscription: Subscription) {
        compositeSubscription.add(subscription)
    }

    protected fun <T> apiRequest(observable: Observable<T>, onComplete: (T) -> Unit, onError: (Throwable) -> Unit, rxBlock: (Observable<T>.() -> Observable<T>)? = null) {
        unsubscribeOnDestroy(simpleNetworkRequest(observable, onComplete, onError, rxBlock))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeSubscription.clear()
    }

}