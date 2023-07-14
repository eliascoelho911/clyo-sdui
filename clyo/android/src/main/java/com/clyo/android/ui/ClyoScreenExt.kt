package com.clyo.android.ui

import android.view.ViewGroup
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.tools.tools
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.Json

fun ViewGroup.show(clyoScreen: ClyoScreen) {
    clyoScreen.container.into.addView(view)
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