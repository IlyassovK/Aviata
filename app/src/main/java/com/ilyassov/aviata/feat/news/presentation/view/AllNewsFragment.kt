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
import com.ilyassov.aviata.databinding.FragmentAllNewsBinding
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.feat.news.presentation.epoxy.NewsEpoxyController
import com.ilyassov.aviata.feat.news.presentation.model.AllNewsScreenState
import com.ilyassov.aviata.feat.news.presentation.viewModel.AllNewsViewModel
import com.ilyassov.aviata.feat.news.presentation.viewModel.NewsViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class AllNewsFragment : Fragment(R.layout.fragment_all_news) {
    private val binding by viewBinding(FragmentAllNewsBinding::bind)
    private val viewModel: AllNewsViewModel by viewModel()

    private val newsViewModel: NewsViewModel by sharedViewModel()

    private var pagedDataJob: Job? = null
    private var isRequest = true

    private lateinit var longPollingJob: Job

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
        setupRequests()
    }

    private fun initView(){
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setController(newsEpoxyController)
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

    private fun setupRequests(){
        isRequest = true
        longPollingJob = addRepeatingJob(Lifecycle.State.STARTED){
            while (isRequest){
                Timber.i("get news request")
                newsEpoxyController.refresh()
                newsEpoxyController.requestModelBuild()
                delay(5000)
            }
        }
    }

    private fun onStateChange(state: AllNewsScreenState){
        when(state) {
            is AllNewsScreenState.Loading -> {
                newsEpoxyController.error = null
                newsEpoxyController.isLoading = true
            }
            is AllNewsScreenState.ErrorLoaded -> {
                newsEpoxyController.error = state.message
                newsEpoxyController.isLoading = false
            }
        }
    }

    private fun startPaginationObserver(){
        pagedDataJob?.cancel()
        pagedDataJob = addRepeatingJob(Lifecycle.State.STARTED){
            viewModel.paginateAllNews().collectLatest {
                onItemPaginated(it)
            }
        }
    }

    private fun onItemPaginated(data: PagingData<NewsItemView>){
        newsEpoxyController.error = null
        newsEpoxyController.isLoading = false
        lifecycleScope.launch {
            newsEpoxyController.submitData(data)
        }
    }
}