package com.clyo.android.impl.layout

import android.content.Context
import android.widget.FrameLayout
import com.clyo.android.ui.Container

internal class BoxContainer : Container<FrameLayout>() {
    override fun newViewInstance(context: Context): FrameLayout {
        return FrameLayout(context)
    }
}