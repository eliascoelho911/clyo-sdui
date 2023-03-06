package com.clyo.android.component.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.clyo.android.R

class WidgetContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var positionId: String? = null

    init {
        getAttrs(context, attrs)
    }

    private fun getAttrs(context: Context, attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.WidgetContainerView,
            0, 0
        ).apply {
            try {
                positionId = getString(R.styleable.WidgetContainerView_position)
            } finally {
                recycle()
            }
        }
    }
}