package com.clyo.android.ui

import android.view.View
import android.view.ViewGroup
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.tools.containerFactory
import com.clyo.android.tools.tools
import com.clyo.data.container.ContainerJson
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.Json

data class ClyoScreen(val container: Container<*>) {
    val view: View
        get() = container.getView()
}

internal fun clyoScreen(json: ContainerJson): ClyoScreen {
    val container = containerFactory().create(json)
    return ClyoScreen(container)
}

fun ClyoScreen.showOnViewGroup(into: ViewGroup) {
    container.render()

    into.addView(view)
}

fun ClyoScreen.render(propertiesJson: PropertiesJson) {
    render(propertiesJson, tools().json)
}

private fun ClyoScreen.render(propertiesJson: PropertiesJson, json: Json) {
    container.widgets.forEach { widget ->
        val properties = propertiesJson.decodeProperties(json, widget.id)
        widget.render(properties)
    }
}