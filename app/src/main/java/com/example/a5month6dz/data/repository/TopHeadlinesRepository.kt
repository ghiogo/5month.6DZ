package com.example.a5month6dz.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.a5month6dz.data.remote.apiservice.TopHeadlinesApiService
import com.example.a5month6dz.data.repository.pagingsources.TopHeadlinesPagingSources
import com.example.a5month6dz.models.ArticlesItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopHeadlinesRepository @Inject constructor(
    private val topHeadlinesApiService: TopHeadlinesApiService
) {
    fun fetchTopHeadlines(): Flow<PagingData<ArticlesItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                TopHeadlinesPagingSources(topHeadlinesApiService)
            }).flow
    }
}