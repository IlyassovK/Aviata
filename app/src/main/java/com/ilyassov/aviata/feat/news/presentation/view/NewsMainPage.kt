package com.ilyassov.aviata.feat.news.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.ilyassov.aviata.R
import com.ilyassov.aviata.databinding.FragmentNewsMainPageBinding
import com.ilyassov.aviata.feat.news.presentation.adapter.NewsTabAdapter
import com.ilyassov.aviata.util.Utils

class NewsMainPage : Fragment(R.layout.fragment_news_main_page) {
    private val binding by viewBinding(FragmentNewsMainPageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews(){
        val newsTabAdapter = NewsTabAdapter(this@NewsMainPage)

        binding.apply {
            appbar.title.text = getString(R.string.msg_news)

            newsPager.adapter = newsTabAdapter

            appbar.favorite.setOnClickListener {
                findNavController().navigate(
                    R.id.action_newsMainPage_to_favoriteFragment
                )
            }

            TabLayoutMediator(tabLayout, newsPager) { tab, position ->
                when(position) {
                    0 -> {
                        tab.text = getString(R.string.msg_everything)
                    }
                    1 -> {
                        tab.text = getString(R.string.msg_headlines)
                    }
                }
            }.attach()

        }
    }

}