package com.example.mylabwork.top

import androidx.lifecycle.viewModelScope
import com.example.mylabwork.base.BaseGifStorageViewModel
import com.example.mylabwork.base.DevLifeApiStatus
import com.example.mylabwork.network.DevLifeApi
import kotlinx.coroutines.launch

class TopViewModel: BaseGifStorageViewModel() {

    init {
        downloadData()
        isAtFirstPage.value = true
    }

    override fun downloadData() {
        viewModelScope.launch {
            try {
                queryPageNumber++
                _status.value = DevLifeApiStatus.LOADING
                val getTopPropertiesDeferred =
                    DevLifeApi.retrofitService.getTopPropertiesAsync(queryPageNumber)
                _status.value = DevLifeApiStatus.DONE
                val result = getTopPropertiesDeferred.await()
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
