package com.example.mylabwork.viewmodels.hot

import com.example.mylabwork.viewmodels.base.GifStorageViewModel
import com.example.mylabwork.network.DevLifeApi
import com.example.mylabwork.network.data.DevLifeProperty

class HotViewModel : GifStorageViewModel() {

    override suspend fun requestGifs(pagination: Int): List<DevLifeProperty> =
        DevLifeApi.retrofitService.getHotPropertiesAsync(pagination).await().result
}