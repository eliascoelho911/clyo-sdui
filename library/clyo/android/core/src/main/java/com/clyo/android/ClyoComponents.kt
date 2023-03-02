package com.clyo.android

import com.clyo.android.component.container.ContainerModule
import com.clyo.android.component.container.emptyContainerModule
import com.clyo.android.component.widget.WidgetModule
import com.clyo.android.component.widget.emptyWidgetModule

class ClyoComponents internal constructor(
    val widgetModule: WidgetModule = emptyWidgetModule(),
    val containerModule: ContainerModule = emptyContainerModule()
)

fun emptyClyoComponents() = ClyoComponents()