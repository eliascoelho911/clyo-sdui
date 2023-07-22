package com.clyo.sample.impl.container

import android.content.Context
import com.clyo.android.component.ComponentType
import com.clyo.android.component.Container
import com.clyo.android.component.ContainerProvider
import com.clyo.sample.components.container.Column

internal class ContainerProviderImpl : ContainerProvider {
    override fun provideByType(
        context: Context,
        type: ComponentType,
    ): Container<*> {
        return when (type.type) {
            "column" -> Column(context)
            else -> throw IllegalArgumentException("Unknown container to type ${type.type}")
        }
    }
}