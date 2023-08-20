package com.unfocusableviewpager2.sample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.unfocusableviewpager2.sample.databinding.TabFragmentBinding

class TabFragment : Fragment() {
    private var _binding: TabFragmentBinding? = null
    private val binding get() = _binding!!

    private val colorsList = listOf(Color.CYAN, Color.YELLOW, Color.MAGENTA)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = TabFragmentBinding.inflate(inflater)

        initViews()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initViews() {
        val position = arguments?.getInt("position") ?: 0
        binding.root.setBackgroundColor(colorsList[position])
    }
}