package com.clyo.android.page

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class PageHolder @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    fun show(page: Page) {
        showOnlyPage(page)
    }

    private fun showOnlyPage(page: Page) {
        removeAllViews()
        addView(page.container.view)
    }
}