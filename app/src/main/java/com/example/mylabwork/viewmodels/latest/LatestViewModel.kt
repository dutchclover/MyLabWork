package com.example.mylabwork.viewmodels.latest

import com.example.mylabwork.viewmodels.base.GifStorageViewModel
import com.example.mylabwork.network.DevLifeApi
import com.example.mylabwork.network.data.DevLifeProperty

class LatestViewModel : GifStorageViewModel() {

    override suspend fun requestGifs(pagination: Int): List<DevLifeProperty> =
         DevLifeApi.retrofitService.getLatestPropertiesAsync(pagination).await().result
}

