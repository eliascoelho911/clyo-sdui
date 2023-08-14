package com.clyo.android.page

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class PageHolder @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    fun show(containerPage: ContainerPage) {
        showOnlyPage(containerPage)
    }

    private fun showOnlyPage(containerPage: ContainerPage) {
        removeAllViews()
        addView(containerPage.container.view)
    }
}