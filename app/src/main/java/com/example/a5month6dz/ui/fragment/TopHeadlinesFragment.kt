package com.example.a5month6dz.ui.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.a5month6dz.R
import com.example.a5month6dz.base.BaseFragment
import com.example.a5month6dz.databinding.FragmentTopHeadlinesBinding
import com.example.a5month6dz.ui.adapter.TopHeadlinesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopHeadlinesFragment :
    BaseFragment<FragmentTopHeadlinesBinding, TopHeadlinesViewModel>(R.layout.fragment_top_headlines) {

    override val binding by viewBinding(FragmentTopHeadlinesBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()
    private val newsAdapter = TopHeadlinesAdapter()

    override fun initialize() {
        binding.rvTopHeadlines.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchTopHeadlines().collect {
                newsAdapter.submitData(it)
            }
        }
    }
}