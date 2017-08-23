package com.whoame.dressme.model

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.whoame.dressme.App
import com.whoame.dressme.util.SharedPreference
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.RealmResults
import javax.inject.Inject

class Database {

    @Inject lateinit var gson: Gson

    private val realm: Realm by lazy { Realm.getDefaultInstance() }
    private val ITEM_SYNC_CONFIG_PREF = "items"
    private val itemsSyncConfig: HashMap<String, Int>? = null
        get() {
            if (field == null) {
                val type = object : TypeToken<HashMap<String, Int>>() {}.type
                val fromJson = gson.fromJson<HashMap<String, Int>?>(SharedPreference.read(ITEM_SYNC_CONFIG_PREF), type) ?: HashMap()
                field = fromJson
            }
            return field
        }

    init {
        App.appComponent.inject(this)
    }

    fun <T : RealmObject> createOrUpdate(model: T, onComplete: (() -> Unit)? = null, onError: ((Throwable) -> Unit)? = null) {
        realm.executeTransactionAsync({ it.copyToRealmOrUpdate(model) }, onComplete, onError)
    }

    fun <T : RealmObject> createOrUpdate(models: List<T>, onComplete: (() -> Unit)? = null, onError: ((Throwable) -> Unit)? = null) {
        realm.executeTransactionAsync({ it.copyToRealmOrUpdate(models) }, onComplete, onError)
    }

    fun <T : RealmObject> createOrUpdate(models: RealmList<T>, onComplete: (() -> Unit)? = null, onError: ((Throwable) -> Unit)? = null) {
        realm.executeTransactionAsync({ it.copyToRealmOrUpdate(models) }, onComplete, onError)
    }

    fun <T : RealmObject> createOrUpdate(itemsHolder: ListResponse<T>, onComplete: (() -> Unit)? = null, onError: ((Throwable) -> Unit)? = null) {
        if (itemsHolder.items.isNotEmpty()) {
            setTotalItemsCount(itemsHolder.items.first().javaClass.simpleName, itemsHolder.count)
            realm.executeTransactionAsync({ it.copyToRealmOrUpdate(itemsHolder.items) }, onComplete, onError)
        }
    }

    fun <T : RealmObject> deleteObject(item: RealmResults<T>) {
        realm.beginTransaction()
        item.deleteAllFromRealm()
        realm.commitTransaction()
    }

    fun <T : RealmObject> getAll(clazz: Class<T>) = realm.where(clazz).findAll()

    fun <T : RealmObject> getByTag(clazz: Class<T>, fieldsName: String, value: Int) = realm.where(clazz).equalTo(fieldsName, value).findAll()

    fun <T : RealmObject> getByTag(clazz: Class<T>, fieldsName: String, value: Boolean) = realm.where(clazz).equalTo(fieldsName, value).findAll()

    fun <T : RealmObject> getAllCount(clazz: Class<T>) = realm.where(clazz).count().toInt()

    fun <T : RealmObject> getAllByTag(clazz: Class<T>, fieldsName: String, collection: ArrayList<Int>): RealmResults<T>? {

        val find = realm.where(clazz)
        for (value in collection) {
            find.equalTo(fieldsName, value)
            if (value != collection.last())
                find.or()
        }
        return find.findAll()


    }

    fun setTotalItemsCount(tag: String, count: Int) =
            itemsSyncConfig?.put(tag, count)

    fun getTotalItemsCount(tag: String): Int {
        if (itemsSyncConfig?.contains(tag) == true)
            return itemsSyncConfig?.get(tag) ?: -2
        else
            return -1
    }

    fun clear() {
        realm.beginTransaction()
        realm.deleteAll()
        realm.commitTransaction()
    }

    fun close() {
        realm.close()
        SharedPreference.save(ITEM_SYNC_CONFIG_PREF, gson.toJson(itemsSyncConfig))
    }

}