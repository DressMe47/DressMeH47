package com.whoame.dressme.model

data class ListResponse<T>(var count: Int, var items: ArrayList<T>)
