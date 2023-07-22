package com.clyo.sample.stub

import com.clyo.android.component.container.ContainerData
import com.clyo.android.component.type.ComponentType
import com.clyo.android.component.widget.WidgetData
import com.clyo.android.data.PageData
import com.clyo.sample.components.widget.ButtonArgs
import com.clyo.sample.components.widget.TextArgs

internal object PageDataStub {
    val data = PageData(
        content = ContainerData(
            type = ComponentType("column"),
            content = listOf(
                WidgetData(
                    type = ComponentType("text"),
                    componentArgs = TextArgs(
                        text = "Hello World!"
                    )
                ),
                WidgetData(
                    type = ComponentType("button"),
                    componentArgs = ButtonArgs(
                        text = "Click me!",
                        isEnabled = true
                    )
                )
            )
        )
    )
}