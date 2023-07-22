package com.clyo.sample.components.container

import android.content.Context
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.android.component.container.ContainerData
import com.clyo.android.component.args.ComponentArgs
import com.clyo.android.component.container.Container
import kotlinx.serialization.Serializable

internal class Column(context: Context) : Container<LinearLayoutCompat>() {
    override val view = LinearLayoutCompat(context)
}