package com.clyo.android

import com.clyo.android.container.ContainerProvider
import com.clyo.android.widget.WidgetProvider
import kotlinx.serialization.json.Json

object ClyoApplication {
    lateinit var clyo: Clyo

    fun start(
        widgetProvider: WidgetProvider,
        containerProvider: ContainerProvider,
        json: Json
    ) {
        this.clyo = Clyo(widgetProvider, containerProvider, json)
    }
}