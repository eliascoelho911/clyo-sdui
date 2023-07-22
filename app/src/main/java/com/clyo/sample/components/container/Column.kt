package com.clyo.sample.components.container

import android.content.Context
import com.clyo.android.component.Container

internal class Column(context: Context) : Container<ColumnLayout>() {
    override val view = ColumnLayout(context)
}