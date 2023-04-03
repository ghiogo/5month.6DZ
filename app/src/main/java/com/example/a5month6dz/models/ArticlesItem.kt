package com.example.a5month6dz.models

import com.example.a5month6dz.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class ArticlesItem(
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    override val url: String,
    @SerializedName("content")
    val content: String
) : IBaseDiffModel