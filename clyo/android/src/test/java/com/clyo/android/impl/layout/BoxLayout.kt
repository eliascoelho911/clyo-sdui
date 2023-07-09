package com.clyo.android.impl.layout

import android.content.Context
import android.widget.FrameLayout
import com.clyo.android.ui.layout.Layout

internal class BoxLayout : Layout<FrameLayout>() {
    override fun createView(context: Context): FrameLayout {
        return FrameLayout(context)
    }
}