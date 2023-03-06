package com.clyo.android.component.container

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import com.clyo.android.component.widget.WidgetContainerView
import com.clyo.android.properties.AbstractPropertiesData

interface ClyoContainer {
    val container: ViewGroup

    fun applyLayoutProperties(view: View, layoutProperties: AbstractPropertiesData)

    fun addWidget(view: View, layoutProperties: AbstractPropertiesData) {
        applyLayoutProperties(view, layoutProperties)
        container.addView(view)
    }
}

interface ClyoTemplateContainer : ClyoContainer {
    override fun addWidget(view: View, layoutProperties: AbstractPropertiesData) {
        applyLayoutProperties(view, layoutProperties)

        val position = layoutProperties.getStringOrNull("position") ?: error("position not found")

        container.children.forEach { childView ->
            if (childView is WidgetContainerView && childView.positionId == position) {
                childView.addView(view)
                return
            }
        }

        error("No widget with position $position was declared in the template")
    }
}