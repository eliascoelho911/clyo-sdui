package com.clyo.android.containers

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.component.container.ClyoContainer

internal class ColumnContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), ClyoContainer {

    init {
        orientation = VERTICAL
    }

    override val viewGroup: ViewGroup = this
}