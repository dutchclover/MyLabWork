package com.example.mylabwork.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylabwork.network.DevLifeProperty

enum class DevLifeApiStatus { LOADING, ERROR, DONE }

abstract class BaseGifStorageViewModel : ViewModel(){

    var isAtFirstPage = MutableLiveData<Boolean>()

    protected val index = 0

    protected var queryPageNumber = -1

    protected var currentPage = -1
    protected val cache = ArrayList<DevLifeProperty>()

    protected val _status = MutableLiveData<DevLifeApiStatus>()

    val status: LiveData<DevLifeApiStatus>
        get() = _status

    protected val _property = MutableLiveData<DevLifeProperty>()

    val property: LiveData<DevLifeProperty>
        get() = _property


    open fun onNext() = if (hasInCache()) {
        _property.value = cache[++currentPage]
        isAtFirstPage.value = false
    } else {
        downloadData()
    }

   open fun onBack() {
       if (currentPage > 1) {
           _property.value = cache[--currentPage]
       } else if (currentPage == 1) {
           _property.value = cache[--currentPage]
           isAtFirstPage.value = true
       }

   }

    fun hasInCache() =
        cache.isNotEmpty() && currentPage < cache.size - 1

    abstract fun downloadData()
}