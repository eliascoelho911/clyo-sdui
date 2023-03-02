package com.clyo.android

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.clyo.android.component.Component

class ClyoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    internal fun show(component: Component<*>) {
        addView(component.view)
    }
}