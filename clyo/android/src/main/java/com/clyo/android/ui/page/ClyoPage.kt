package com.clyo.android.ui.page

import android.view.ViewGroup
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.tools.containerFactory
import com.clyo.android.ui.component.container.Container
import com.clyo.android.ui.component.container.ViewGroupContainer
import com.clyo.android.ui.component.container.render
import com.clyo.data.ClyoPageJson
import com.clyo.data.properties.PropertiesJson

class ClyoPage internal constructor(val containerRoot: ViewGroupContainer<*>) {

    fun submit(clyoPageJson: ClyoPageJson) {
        showIn(into)
        render(clyoPageJson.properties)
    }

    private fun showIn(into: ViewGroup) {
        getContainer().showIn(into)
    }


}

private fun Container.renderContent(propertiesJson: PropertiesJson) {
    val json = ClyoScope.json

    content.forEach { widget ->
        val properties = propertiesJson.decodeProperties(json, widget.id)
        widget.render(properties)
    }
}