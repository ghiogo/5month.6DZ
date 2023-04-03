package com.example.a5month6dz.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.a5month6dz.data.repository.TopHeadlinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(
    private val topHeadlinesRepository: TopHeadlinesRepository
) : ViewModel() {

    fun fetchTopHeadlines() = topHeadlinesRepository.fetchTopHeadlines().cachedIn(viewModelScope)
}
