package com.example.mylabwork.hot

import androidx.lifecycle.viewModelScope
import com.example.mylabwork.base.BaseGifStorageViewModel
import com.example.mylabwork.base.DevLifeApiStatus
import com.example.mylabwork.network.DevLifeApi
import kotlinx.coroutines.launch

class HotViewModel : BaseGifStorageViewModel() {
    init {
        downloadData()
        isAtFirstPage.value = true

    }


    override fun downloadData() {
        viewModelScope.launch {
            try {
                queryPageNumber++
                _status.value = DevLifeApiStatus.LOADING
                val getHotPropertiesDeferred =
                    DevLifeApi.retrofitService.getHotPropertiesAsync(queryPageNumber)
                _status.value = DevLifeApiStatus.DONE
                val result = getHotPropertiesDeferred.await()
                val listResult = result.result
                _property.value = listResult[index]
                listResult.forEach {
                    cache.add(it)
                }
                currentPage++
            } catch (e: Exception) {
                _status.value = DevLifeApiStatus.ERROR
                _property.value = null
            }
        }
    }
}