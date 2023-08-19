package com.pandacorp.unfocusableviewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pandacorp.unfocusableviewpager2.databinding.ActivityMainBinding
import com.pandacorp.unfocusableviewpager2.pager.NavBackStackAdapter
import com.pandacorp.unfocusableviewpager2.pager.SwipeTransformer

class MainActivity : AppCompatActivity() {
    companion object {
        private const val selectionBundleKey = "selectionBundleKey"
    }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var pageSelectionEnabled = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.let {
            pageSelectionEnabled = it.getBoolean(selectionBundleKey)
            setPageSelectionEnabled(pageSelectionEnabled)
        }

        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initViews() {
        binding.viewPager.setPageTransformer(SwipeTransformer())
        binding.viewPager.adapter = NavBackStackAdapter(this)
        binding.viewPager.pageSelectionEnabled = pageSelectionEnabled
        binding.selectionButton.setOnClickListener {
            pageSelectionEnabled = !pageSelectionEnabled
            setPageSelectionEnabled(pageSelectionEnabled)
        }
    }

    private fun setPageSelectionEnabled(pageSelectionEnabled: Boolean) {
        binding.viewPager.pageSelectionEnabled = pageSelectionEnabled
        binding.selectionButton.text = getString(
            if (pageSelectionEnabled) R.string.selectionEnabled
            else R.string.selectionDisabled
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(selectionBundleKey, pageSelectionEnabled)
        super.onSaveInstanceState(outState)
    }
}