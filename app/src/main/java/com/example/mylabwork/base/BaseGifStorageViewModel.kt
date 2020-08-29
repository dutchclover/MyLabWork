package com.example.mylabwork.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylabwork.network.DevLifeProperty

enum class DevLifeApiStatus { LOADING, ERROR, DONE }

abstract class BaseGifStorageViewModel : ViewModel(){

    protected var currentPage = -1
    protected val cache = ArrayList<DevLifeProperty>()

    protected val _status = MutableLiveData<DevLifeApiStatus>()

    val status: LiveData<DevLifeApiStatus>
        get() = _status

    protected val _property = MutableLiveData<DevLifeProperty>()

    val property: LiveData<DevLifeProperty>
        get() = _property

    protected val _properties = MutableLiveData<List<DevLifeProperty>>()

    val properties: LiveData<List<DevLifeProperty>>
        get() = _properties

    open fun onNext() = if (hasInCache()) {
        _property.value = cache[++currentPage]
    } else {
        downloadData()
    }

   open fun onBack() {
        if (currentPage > 0) {
            _property.value = cache[--currentPage]
        }
    }

    private fun hasInCache() =
        cache.isNotEmpty() && currentPage < cache.size - 1

    abstract fun downloadData()
}