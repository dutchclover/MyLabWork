package com.example.mylabwork.network

import com.example.mylabwork.network.data.DevLifeObject
import com.example.mylabwork.network.data.DevLifeProperty
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://developerslife.ru/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface DevLifeApiService {

    @GET("random?json=true")
    fun getPropertyAsync():
            Deferred<DevLifeProperty>

    @GET("top/{page_number}?json=true")
    fun getTopPropertiesAsync(@Path("page_number") page: Int):
            Deferred<DevLifeObject>

    @GET("latest/{page_number}?json=true")
    fun getLatestPropertiesAsync(@Path("page_number") page: Int):
            Deferred<DevLifeObject>

    @GET("hot/{page_number}?json=true")
    fun getHotPropertiesAsync(@Path("page_number") page: Int):
            Deferred<DevLifeObject>
}

object DevLifeApi {
    val retrofitService : DevLifeApiService by lazy { retrofit.create(DevLifeApiService::class.java) }
}

