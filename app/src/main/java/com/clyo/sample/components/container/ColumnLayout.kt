package com.clyo.sample.components.container

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat

internal class ColumnLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {
    init {
        orientation = VERTICAL
    }
}