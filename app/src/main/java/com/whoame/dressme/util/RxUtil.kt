package com.whoame.dressme.util

import android.util.Log
import retrofit2.adapter.rxjava.HttpException
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

fun <T> simpleNetworkRequest(observable: Observable<T>, onComplete: (T) -> Unit, onError: (Throwable) -> Unit, rxBlock: (Observable<T>.() -> Observable<T>)? = null): Subscription =
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .apply {
                    if (rxBlock != null)
                        rxBlock()
                }
                .subscribe(onComplete, {
                    var exception = it
                    if (exception is HttpException) {
                        val message = exception.response().errorBody().string()
                        Log.i("NETWORK", "simpleNetworkRequest: message = $message")
                        exception = Throwable(message)
                    }
                    onError.invoke(exception)
                })