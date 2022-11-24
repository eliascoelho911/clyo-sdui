package com.clyo.android.containers

import android.content.Context
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.core.component.ContainerFactory
import com.clyo.core.component.DeclareComponentFactory
import com.clyo.core.data.ComponentProperties

@DeclareComponentFactory("column")
internal class ColumnComponentFactory : ContainerFactory() {
    override fun createInstance(context: Context) = LinearLayoutCompat(context)

    override fun LinearLayoutCompat.bind(properties: ComponentProperties) = apply {
        orientation = properties.getIntOrNull("orientation") ?: 1
    }
}