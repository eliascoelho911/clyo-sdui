package com.clyo.android.component.container

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.children
import com.clyo.android.component.widget.WidgetContainerView
import com.clyo.android.properties.AbstractPropertiesData

interface ClyoContainer {
    val viewGroup: ViewGroup

    fun applyLayoutProperties(view: View, layoutProperties: AbstractPropertiesData) {}

    fun addWidget(view: View, layoutProperties: AbstractPropertiesData) {
        applyLayoutProperties(view, layoutProperties)
        viewGroup.addView(view)
    }
}

fun ClyoContainer.initContainer(@LayoutRes layoutRes: Int) {
    View.inflate(viewGroup.context, layoutRes, viewGroup)
}

interface ClyoTemplateContainer : ClyoContainer {
    override fun addWidget(view: View, layoutProperties: AbstractPropertiesData) {
        applyLayoutProperties(view, layoutProperties)

        val position = layoutProperties.getStringOrNull("position") ?: error("position not found")

        viewGroup.children.forEach { childView ->
            if (childView is WidgetContainerView && childView.positionId == position) {
                childView.addView(view)
                return
            }
        }

        error("No widget with position $position was declared in the template")
    }
}