package com.clyo.android.containers

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.R
import com.clyo.android.component.container.initContainer
import com.clyo.android.component.container.template.ClyoTemplateContainer

internal class FeedbackContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), ClyoTemplateContainer {

    override val viewGroup: ViewGroup = this

    init {
        initContainer(R.layout.view_feedback_container)
        orientation = VERTICAL
    }
}