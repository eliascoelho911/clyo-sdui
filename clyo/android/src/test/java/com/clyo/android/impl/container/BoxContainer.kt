package com.clyo.android.impl.container

import android.content.Context
import android.widget.FrameLayout
import com.clyo.android.ui.component.container.ViewGroupContainer
import com.clyo.android.ui.component.widget.Widget

internal class BoxContainer(
    context: Context,
    override val content: List<Widget<*, *>>,
    override val view: FrameLayout = FrameLayout(context)
) : ViewGroupContainer<FrameLayout>()