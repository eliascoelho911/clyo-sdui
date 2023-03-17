package com.clyo.android.containers

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.component.properties.BasePropertiesData

internal class ColumnContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), ClyoContainer {

    override val viewGroup: ViewGroup = this

    override var isTemplate: Boolean = false

    init {
        orientation = VERTICAL
    }

    override fun applyLayoutProperties(view: View, layoutProperties: BasePropertiesData) {
        view.layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
    }
}