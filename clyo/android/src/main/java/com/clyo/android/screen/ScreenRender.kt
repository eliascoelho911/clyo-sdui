package com.clyo.android.screen

import com.clyo.android.scope.ClyoScope
import com.clyo.screen.ScreenData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun ClyoScope.newScreen(jsonValue: String): Screen {
    val factory = containerPageFactory()
    val screenData = jsonValue.decodeToScreenData(json)
    return factory.create(screenData)
}

fun ClyoScope.showNewScreen(jsonValue: String, holder: ScreenHolder) {
    val screen = newScreen(jsonValue)
    holder.show(screen)
}

private fun ClyoScope.containerPageFactory(): ScreenFactory {
    return ScreenFactory(androidContext, widgetProvider, containerProvider)
}

private fun String.decodeToScreenData(json: Json): ScreenData {
    return json.decodeFromString(this)
}