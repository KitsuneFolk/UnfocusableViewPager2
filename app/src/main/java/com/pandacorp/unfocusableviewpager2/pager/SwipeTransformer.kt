/*
 * Copyright 2023 Fragula contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pandacorp.unfocusableviewpager2.pager

import android.view.View
import com.pandacorp.viewpager2.widget.ViewPager2

class SwipeTransformer : ViewPager2.PageTransformer {
    private val parallaxFactor: Float = 1.15f
    private val scrimFactor: Float = 1.15f

    override fun transformPage(page: View, position: Float) {
        when {
            // All fragments to the right of the current one
            position <= -1 -> {
                page.visibility = View.INVISIBLE
                page.alpha = 1.0f
            }
            // The screen that appears to the right of the current one when opening a new fragment
            position > 0 && position < 1 -> {
                page.translationX = 0f
                page.visibility = View.VISIBLE
                page.alpha = 1.0f
            }
            // Animation for the current fragment exiting when opening a new one
            position > -1 && position <= 0 -> {
                page.translationX = -page.width * position / parallaxFactor
                page.visibility = View.VISIBLE
                page.alpha = 1.0f - (position * scrimFactor) // Add scrim
            }
            // All fragments to the left of the current one
            else -> {
                page.visibility = View.INVISIBLE
                page.alpha = 1.0f
            }
        }
    }
}