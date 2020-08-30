package com.example.mylabwork.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mylabwork.ui.hot.HotFragment
import com.example.mylabwork.ui.latest.LatestFragment
import com.example.mylabwork.ui.random.RandomFragment
import com.example.mylabwork.ui.top.TopFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RandomFragment()
            1 -> LatestFragment()
            2 -> TopFragment()
            else -> HotFragment()
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}