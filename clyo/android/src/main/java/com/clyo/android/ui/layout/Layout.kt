package com.clyo.android.ui.layout

import android.view.ViewGroup
import com.clyo.android.ui.common.ViewComponent
import com.clyo.android.ui.widget.Widget
import com.clyo.data.properties.Properties
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

abstract class Layout<VIEW : ViewGroup> : ViewComponent<VIEW>() {
    private val _children: MutableList<Widget<*, *>> = mutableListOf()

    val children: List<Widget<*, *>>
        get() = _children

    fun addAll(widgets: List<Widget<*, *>>): ViewGroup {
        widgets.forEach(::add)

        return getView()
    }

    fun add(widget: Widget<*, *>): ViewGroup = applyOnView {
        addView(widget.getView())
        _children.add(widget)
    }

    // Todo: Mover para outro lugar
    fun render(properties: PropertiesJson) {
        children.forEach { widget ->
//            widget.render(properties.getProperties(widget.id))
        }
    }
}