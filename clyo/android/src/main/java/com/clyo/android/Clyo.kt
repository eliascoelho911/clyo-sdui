package com.clyo.android

import com.clyo.android.container.ContainerProvider
import com.clyo.android.widget.WidgetProvider
import kotlinx.serialization.json.Json

class Clyo internal constructor(
    internal val widgetProvider: WidgetProvider,
    internal val containerProvider: ContainerProvider,
    internal val json: Json
)

fun clyo(
    widgetProvider: WidgetProvider,
    containerProvider: ContainerProvider,
    json: Json
) = Clyo(widgetProvider, containerProvider, json)