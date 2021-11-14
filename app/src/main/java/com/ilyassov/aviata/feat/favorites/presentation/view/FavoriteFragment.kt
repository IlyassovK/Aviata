package com.ilyassov.aviata.feat.favorites.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ilyassov.aviata.R
import com.ilyassov.aviata.databinding.FragmentFavoriteBinding
import com.ilyassov.aviata.feat.favorites.presentation.model.FavoriteScreenState
import com.ilyassov.aviata.feat.favorites.presentation.viewModel.FavoriteViewModel
import com.ilyassov.aviata.feat.news.presentation.epoxy.newsItem
import com.ilyassov.aviata.feat.news.presentation.viewModel.NewsViewModel
import com.ilyassov.aviata.util.common.ui.epoxy.component.emptyList
import com.ilyassov.aviata.util.common.ui.epoxy.component.loading
import com.ilyassov.aviata.util.common.ui.epoxy.component.messageError
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val binding by viewBinding(FragmentFavoriteBinding::bind)
    private val viewModel: FavoriteViewModel by viewModel()

    private val newsViewModel: NewsViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupObservers()
    }

    private fun initView(){
        binding.apply {
            appbar.title.text = getString(R.string.msg_favorites)
            appbar.backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

    }

    private fun setupObservers(){
        addRepeatingJob(Lifecycle.State.STARTED){
            viewModel.state.collect {
                onStateChange(it)
            }
        }
    }

    private fun onStateChange(state: FavoriteScreenState){
        binding.recyclerView.withModels {
            when(state){
                is FavoriteScreenState.Loading -> {
                    loading {
                        id("loading")
                    }
                }
                is FavoriteScreenState.Loaded -> {

                    if(state.data.isEmpty()){
                        emptyList {
                            id("empty")
                        }
                    }

                    state.data.forEach { item ->
                        newsItem {
                            id(item.id)
                            model(item)
                            listener {
                                newsViewModel.selectNews(item)
                                findNavController().navigate(
                                    R.id.action_favoriteFragment_to_newsDetails
                                )
                            }
                        }
                    }
                }
                is FavoriteScreenState.ErrorLoaded -> {
                    messageError {
                        id("error")
                    }
                }
            }
        }
    }
}