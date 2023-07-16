package com.clyo.stubs

import com.clyo.data.container.ContainerJson

internal object BoxContainerStub {
    val containerJson = ContainerJson(
        type = "box",
        content = listOf(TextStub.widgetJson)
    )
}