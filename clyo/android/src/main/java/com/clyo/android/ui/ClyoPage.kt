package com.clyo.android.ui

import android.view.ViewGroup
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.tools.containerFactory
import com.clyo.android.tools.tools
import com.clyo.data.ClyoPageJson
import com.clyo.data.properties.PropertiesJson

class ClyoPage {

    private lateinit var container: Container<*>

    fun submit(clyoPageJson: ClyoPageJson, into: ViewGroup) {
        createContainer(into, clyoPageJson)
        show(into)
        render(clyoPageJson.properties)
    }

    private fun createContainer(into: ViewGroup, clyoPageJson: ClyoPageJson) {
        container = containerFactory.create(into.context, clyoPageJson.content)
    }

    private fun show(into: ViewGroup) {
        container.show()

        into.addView(container.view)
    }

    private fun render(propertiesJson: PropertiesJson) {
        val json = tools().json

        container.content.forEach { widget ->
            val properties = propertiesJson.decodeProperties(json, widget.id)
            widget.render(properties)
        }
    }
}

fun clyoPage(): ClyoPage = ClyoPage()