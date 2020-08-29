package com.example.mylabwork.network

import com.squareup.moshi.Json

data class DevLifeProperty(
    val id: String,
    @Json(name = "gifURL") val gifSrcUrl: String,
    val description: String
)
