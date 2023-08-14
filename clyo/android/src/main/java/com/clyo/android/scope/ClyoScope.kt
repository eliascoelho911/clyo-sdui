package com.clyo.android.scope

import android.content.Context
import com.clyo.android.ClyoApplication
import com.clyo.android.container.ContainerProvider
import com.clyo.android.widget.WidgetProvider
import kotlinx.serialization.json.Json

class ClyoScope internal constructor(
    internal val androidContext: Context
) {
    internal val widgetProvider: WidgetProvider = ClyoApplication.clyo.widgetProvider
    internal val containerProvider: ContainerProvider = ClyoApplication.clyo.containerProvider
    internal val json: Json = ClyoApplication.clyo.json
}