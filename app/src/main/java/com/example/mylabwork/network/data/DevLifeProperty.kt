package com.example.mylabwork.network.data

import com.squareup.moshi.Json


data class DevLifeProperty(
    val id: String,
    val description: String,
    @Json(name = "gifURL") val gifSrcUrl: String
)

