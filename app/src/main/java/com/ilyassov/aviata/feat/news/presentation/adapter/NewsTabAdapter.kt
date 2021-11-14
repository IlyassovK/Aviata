package com.ilyassov.aviata.feat.news.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ilyassov.aviata.feat.news.presentation.view.AllNewsFragment
import com.ilyassov.aviata.feat.news.presentation.view.HeadlinesNewsFragment

class NewsTabAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllNewsFragment()
            1 -> HeadlinesNewsFragment()
            else -> throw Exception("Many fragment exception")
        }
    }
}