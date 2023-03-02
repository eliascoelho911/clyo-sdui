package com.clyo.android

import com.clyo.android.component.widget.WidgetModule
import com.clyo.android.component.widget.emptyWidgetModule

class ClyoComponents internal constructor(
    val widgetModule: WidgetModule = emptyWidgetModule()
)

fun emptyClyoComponents() = ClyoComponents()