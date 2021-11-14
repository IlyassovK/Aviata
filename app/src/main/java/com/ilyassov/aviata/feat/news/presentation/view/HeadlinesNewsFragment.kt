package com.ilyassov.aviata.feat.news.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ilyassov.aviata.R
import com.ilyassov.aviata.databinding.FragmentHeadlinesNewsBinding
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.feat.news.presentation.epoxy.NewsEpoxyController
import com.ilyassov.aviata.feat.news.presentation.epoxy.newsItem
import com.ilyassov.aviata.feat.news.presentation.model.HeadlineNewsScreenState
import com.ilyassov.aviata.feat.news.presentation.viewModel.HeadlineNewsViewModel
import com.ilyassov.aviata.feat.news.presentation.viewModel.NewsViewModel
import com.ilyassov.aviata.util.common.ui.epoxy.component.loading
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeadlinesNewsFragment : Fragment(R.layout.fragment_headlines_news) {
    private val binding by viewBinding(FragmentHeadlinesNewsBinding::bind)
    private val viewModel: HeadlineNewsViewModel by viewModel()

    private val newsViewModel: NewsViewModel by sharedViewModel()

    private var pagedDataJob: Job? = null

    private val newsEpoxyController: NewsEpoxyController by lazy {
        NewsEpoxyController(
            this::navigateToDetail
        )
    }

    private fun navigateToDetail(item: NewsItemView){
        newsViewModel.selectNews(item)
        findNavController().navigate(
            R.id.action_newsMainPage_to_newsDetails
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupObserver()
    }

    private fun initView(){
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setController(newsEpoxyController)

            swipeRefreshLayout.setOnRefreshListener {
                newsEpoxyController.refresh()
                newsEpoxyController.requestModelBuild()
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    private fun setupObserver(){
        addRepeatingJob(Lifecycle.State.STARTED){
            viewModel.state.collect { state ->
                onStateChange(state)
            }
        }

        startPaginationObserver()
    }

    private fun startPaginationObserver(){
        pagedDataJob?.cancel()
        pagedDataJob = addRepeatingJob(Lifecycle.State.STARTED){
            viewModel.paginateHeadlineNews().collectLatest {
                onItemPaginated(it)
            }
        }
    }

    private fun onItemPaginated(data: PagingData<NewsItemView>){
        newsEpoxyController.error = null
        newsEpoxyController.isLoading = false
        lifecycleScope.launchWhenStarted {
            newsEpoxyController.submitData(data)
        }
    }

    private fun onStateChange(state: HeadlineNewsScreenState){
        when(state) {
            is HeadlineNewsScreenState.Loading -> {
                newsEpoxyController.isLoading = true
                newsEpoxyController.error = null
            }
            is HeadlineNewsScreenState.ErrorLoaded -> {
                newsEpoxyController.isLoading = false
                newsEpoxyController.error = null
            }
        }
    }
}