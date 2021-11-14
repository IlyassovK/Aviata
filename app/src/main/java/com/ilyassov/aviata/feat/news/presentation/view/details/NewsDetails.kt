package com.ilyassov.aviata.feat.news.presentation.view.details

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.ilyassov.aviata.R
import com.ilyassov.aviata.databinding.FragmentNewsDetailBinding
import com.ilyassov.aviata.extension.formatDateTime
import com.ilyassov.aviata.feat.news.domain.model.NewsItemView
import com.ilyassov.aviata.feat.news.presentation.viewModel.NewsViewModel
import com.ilyassov.aviata.util.Utils
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class NewsDetails: Fragment(R.layout.fragment_news_detail) {

    private val binding by viewBinding(FragmentNewsDetailBinding::bind)
    private val newsViewModel: NewsViewModel by sharedViewModel()

    private lateinit var circularProgressDrawable: CircularProgressDrawable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupObserver()
    }

    private fun initView() {

        circularProgressDrawable = CircularProgressDrawable(requireContext()).also {
            it.strokeWidth = 5f
            it.centerRadius = 30f
            it.start()
        }

        binding.apply {
            appbar.title.text = getString(R.string.msg_news)

            appbar.backButton.setOnClickListener {
                findNavController().popBackStack()
            }

        }
    }

    private fun setupObserver() {
        addRepeatingJob(Lifecycle.State.STARTED) {
            newsViewModel.selectedNews.collect { selectedNews ->
                selectedNews?.let {
                    onSelectedItem(selectedNews)
                }
            }
        }
    }

    private fun onSelectedItem(item: NewsItemView) {
        binding.apply {

            Glide.with(requireContext())
                .load(item.urlToImage)
                .placeholder(circularProgressDrawable)
                .into(image)

            newsTitle.text = item.title
            description.text = item.description
            author.text = item.author

            date.text = item.publishedAt.formatDateTime(Utils.serverDateFormat, Utils.dateFormat)

            favorite.apply {
                visibility = View.VISIBLE

                if (findNavController().previousBackStackEntry?.destination?.id == R.id.favoriteFragment) {
                    setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.ic_baseline_delete_24,
                            requireContext().theme
                        )
                    )

                    setOnClickListener {
                        newsViewModel.deleteFavorite(item)
                        findNavController().popBackStack()
                    }

                } else {
                    setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.ic_baseline_favorite_24,
                            requireContext().theme
                        )
                    )

                    setOnClickListener {
                        newsViewModel.insertFavorite(item)
                    }
                }
            }

        }
    }
}
