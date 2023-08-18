package com.pandacorp.unfocusableviewpager2.pager

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.pandacorp.unfocusableviewpager2.TabFragment
import com.pandacorp.viewpager2.adapter.FragmentStateAdapter

class NavBackStackAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment = TabFragment().apply {
        arguments = bundleOf("position" to position)
    }

    override fun getItemCount(): Int = 3
}