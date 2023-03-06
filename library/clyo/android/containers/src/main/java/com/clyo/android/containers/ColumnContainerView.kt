package com.clyo.android.containers

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.properties.AbstractPropertiesData

internal class ColumnContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), ClyoContainer {

    init {
        orientation = VERTICAL
    }

    override val container: ViewGroup = this

    override fun applyLayoutProperties(view: View, layoutProperties: AbstractPropertiesData) {
        // do nothing
    }
}