package com.example.a5month6dz.models

import com.google.gson.annotations.SerializedName

data class NewsModel<T>(
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<T>,
    @SerializedName("status")
    val status: String
)