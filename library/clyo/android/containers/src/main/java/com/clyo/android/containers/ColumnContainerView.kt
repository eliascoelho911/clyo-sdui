package com.clyo.android.containers

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.component.container.ClyoContainerView
import com.clyo.android.properties.AbstractPropertiesData

internal class ColumnContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), ClyoContainerView {
    init {
        orientation = VERTICAL
    }

    override fun addWidget(view: View, layoutProperties: AbstractPropertiesData) {
        addView(view)
    }
}