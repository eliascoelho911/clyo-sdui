package com.clyo.android.scope

import android.view.ViewGroup
import com.clyo.android.common.properties.decodeProperties
import com.clyo.android.ui.page.Page
import com.clyo.android.ui.page.PageFactory
import com.clyo.data.PageJson
import com.clyo.data.properties.PropertiesJson
import kotlinx.serialization.json.Json

class Clyo internal constructor(
    private val pageFactory: PageFactory,
    private val json: Json
) {
    fun submit(pageJson: PageJson, parent: ViewGroup) {
        val page = getPage(parent, pageJson)

        attachPageToParent(page, parent)

        renderPage(page, propertiesJson = pageJson.properties)
    }

    private fun getPage(
        parent: ViewGroup,
        pageJson: PageJson
    ): Page = pageFactory.create(parent.context, pageJson)

    private fun attachPageToParent(page: Page, parent: ViewGroup) {
        page.attachTo(parent)
    }

    private fun renderPage(page: Page, propertiesJson: PropertiesJson) {
        page.render(properties = { widgetId ->
            propertiesJson.decodeProperties(json, widgetId)
        })
    }
}