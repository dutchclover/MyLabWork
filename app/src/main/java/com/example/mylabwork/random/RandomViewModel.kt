package com.example.mylabwork.random

import androidx.lifecycle.viewModelScope
import com.example.mylabwork.base.BaseGifStorageViewModel
import com.example.mylabwork.base.DevLifeApiStatus
import com.example.mylabwork.network.DevLifeApi
import kotlinx.coroutines.launch

class RandomViewModel : BaseGifStorageViewModel() {


    init {
        isAtFirstPage.value = true
        downloadData()
    }

    override fun downloadData() {
        viewModelScope.launch {
            val getPropertyDeferred = DevLifeApi.retrofitService.getPropertyAsync()
            try {
                _status.value = DevLifeApiStatus.LOADING
                val result = getPropertyDeferred.await()
                _status.value = DevLifeApiStatus.DONE
                _property.value = result
                cache.add(result)
                currentPage++
            } catch (e: Exception) {
                _status.value = DevLifeApiStatus.ERROR
                _property.value = null
            }
        }
    }
}