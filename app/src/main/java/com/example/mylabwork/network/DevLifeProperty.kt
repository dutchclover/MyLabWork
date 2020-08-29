package com.example.mylabwork.network

import com.squareup.moshi.Json


data class DevLifeProperty(
    val id: String,
    val description: String,
    val votes: Int,
    val author : String,
    val date : String,
    @Json(name = "gifURL") val gifSrcUrl: String,
    val gifSize : Int,
    val previewURL : String,
    val videoURL : String,
    val videoPath : String,
    val videoSize : Int,
    val type : String,
    val width : Int,
    val height : Int,
    val commentsCount : Int,
    val fileSize : Int,
    val canVote : Boolean)
