package com.clyo.android.containers

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.R
import com.clyo.android.component.container.ClyoContainer
import com.clyo.android.component.container.initContainer
import com.clyo.android.component.properties.BasePropertiesData

internal class FeedbackContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), ClyoContainer {

    override val viewGroup: ViewGroup = this

    override var isTemplate: Boolean = true
    init {
        initContainer(R.layout.view_feedback_container)
        orientation = VERTICAL
    }

    override fun applyLayoutProperties(view: View, layoutProperties: BasePropertiesData) {
    }
}