package com.eliascoelho911.clyo.android.containers

import android.content.Context
import androidx.appcompat.widget.LinearLayoutCompat
import com.clyo.core.android.ContainerFactory
import com.clyo.core.android.annotation.DeclareComponentFactory
import com.eliascoelho911.clyo.ComponentProperties

@DeclareComponentFactory("layout.column")
internal class ColumnComponentFactory : ContainerFactory() {
    override fun createInstance(context: Context) = LinearLayoutCompat(context)

    override fun LinearLayoutCompat.bind(properties: ComponentProperties) = apply {
        orientation = properties.get("orientation")
    }
}