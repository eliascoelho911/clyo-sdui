package com.clyo.android.screen

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScreenHolder @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val basePadding = Rect(
        paddingLeft,
        paddingTop,
        paddingRight,
        paddingBottom
    )

    init {
        ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                basePadding.left + systemBars.left,
                basePadding.top + systemBars.top,
                basePadding.right + systemBars.right,
                basePadding.bottom + systemBars.bottom
            )
            insets
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ViewCompat.requestApplyInsets(this)
    }

    fun show(screen: Screen) {
        showOnlyPage(screen)
    }

    private fun showOnlyPage(screen: Screen) {
        removeAllViews()
        addView(screen.container.view)
    }
}
