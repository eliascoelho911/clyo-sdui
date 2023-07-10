package com.clyo.android.impl.layout

import android.content.Context
import android.widget.FrameLayout
import com.clyo.android.ui.component.container.Container

internal class BoxContainer : Container<FrameLayout>() {
    override fun createView(context: Context): FrameLayout {
        return FrameLayout(context)
    }
}