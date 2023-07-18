package com.clyo.sample.components.container

import android.content.Context
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.widget.Widget

internal fun column(context: Context, content: List<Widget<*, *>>) = Container(
    view = columnView(context),
    content = content
)

private fun columnView(context: Context) = LinearLayoutCompat(context).apply {
    orientation = LinearLayoutCompat.VERTICAL
}