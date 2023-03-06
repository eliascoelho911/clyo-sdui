package com.clyo.android.containers

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.children
import com.clyo.android.R
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.component.widget.WidgetContainerView
import com.clyo.android.properties.AbstractPropertiesData

internal class FeedbackContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), ClyoContainer {

    init {
        inflate(context, R.layout.view_feedback_container, this)
        orientation = VERTICAL
    }

    override val container: ViewGroup = this

    override fun addWidget(view: View, layoutProperties: AbstractPropertiesData) {
        addWidgetOnTemplate(view, layoutProperties)
    }
}

private fun ClyoContainer.addWidgetOnTemplate(
    view: View,
    layoutProperties: AbstractPropertiesData
) {
    val position = layoutProperties.getStringOrNull("position") ?: error("position not found")

    container.children.forEach { childView ->
        if (childView is WidgetContainerView && childView.positionId == position) {
            childView.addView(view)
            return
        }
    }

    error("No widget with position $position was declared in the template")
}
