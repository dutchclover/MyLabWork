package com.example.mylabwork.viewmodels.random

import com.example.mylabwork.viewmodels.base.GifStorageViewModel
import com.example.mylabwork.network.DevLifeApi
import com.example.mylabwork.network.data.DevLifeProperty

class RandomViewModel : GifStorageViewModel() {

    override suspend fun requestGifs(pagination: Int): List<DevLifeProperty> =
        listOf(DevLifeApi.retrofitService.getPropertyAsync().await())
}