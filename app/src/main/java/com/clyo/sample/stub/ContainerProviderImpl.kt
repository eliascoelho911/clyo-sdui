package com.clyo.sample.stub

import com.clyo.android.tools.ContainerProvider
import com.clyo.android.ui.Container
import com.clyo.sample.stub.container.Box
import com.clyo.sample.stub.container.Column

internal class ContainerProviderImpl : ContainerProvider() {
    override fun provide(type: String): Container<*> {
        return when (type) {
            "box" -> Box()
            "column" -> Column()
            else -> throw IllegalArgumentException("Unknown container type: $type")
        }
    }
}