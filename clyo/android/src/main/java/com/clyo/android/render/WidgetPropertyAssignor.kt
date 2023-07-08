package com.clyo.android.render

import android.view.View
import com.clyo.data.properties.PropertiesJson
import com.clyo.data.widget.WidgetProperties
import com.clyo.tools.json.JsonProvider
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

interface WidgetPropertyAssignor<VIEW : View, PROP : WidgetProperties> {
    val widgetId: String

    fun assign(view: VIEW, properties: PropertiesJson)
}