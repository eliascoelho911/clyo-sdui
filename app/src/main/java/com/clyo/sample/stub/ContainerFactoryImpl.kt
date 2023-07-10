package com.clyo.sample.stub

import com.clyo.android.ui.component.ContainerFactory
import com.clyo.android.ui.component.container.Container
import com.clyo.sample.stub.container.Box
import com.clyo.sample.stub.container.Column

internal class ContainerFactoryImpl : ContainerFactory() {
    override fun provide(type: String): Container<*> {
        return when (type) {
            "box" -> Box()
            "column" -> Column()
            else -> throw IllegalArgumentException("Unknown container type: $type")
        }
    }
}