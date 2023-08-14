package com.clyo.android.screen

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class ScreenHolder @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    fun show(screen: Screen) {
        showOnlyPage(screen)
    }

    private fun showOnlyPage(screen: Screen) {
        removeAllViews()
        addView(screen.container.view)
    }
}