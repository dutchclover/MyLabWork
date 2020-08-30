package com.example.mylabwork.viewmodels.top

import com.example.mylabwork.viewmodels.base.GifStorageViewModel
import com.example.mylabwork.network.DevLifeApi
import com.example.mylabwork.network.data.DevLifeProperty

class TopViewModel : GifStorageViewModel() {

    override suspend fun requestGifs(pagination: Int): List<DevLifeProperty> =
        DevLifeApi.retrofitService.getTopPropertiesAsync(pagination).await().result
}
