package com.example.a5month6dz.data.repository.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.a5month6dz.data.remote.apiservice.TopHeadlinesApiService
import com.example.a5month6dz.models.ArticlesItem

private const val NEWS_STARTING_PAGE_INDEX = 1

class TopHeadlinesPagingSources(private val topHeadlinesApiService: TopHeadlinesApiService) :
    PagingSource<Int, ArticlesItem>() {
    override fun getRefreshKey(state: PagingState<Int, ArticlesItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticlesItem> {
        return try {
            val nextPage = params.key ?: NEWS_STARTING_PAGE_INDEX
            val response = topHeadlinesApiService.fetchTopHeadlines("bitcoin", nextPage)
            val nextPages = nextPage + 1

            LoadResult.Page(
                data = response.articles,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}