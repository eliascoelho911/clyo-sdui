package com.clyo.android.page

import com.clyo.android.scope.ClyoScope
import com.clyo.page.ContainerPageData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun ClyoScope.newPage(jsonValue: String): ContainerPage {
    val factory = containerPageFactory()
    val containerPageData = jsonValue.decodeToContainerPage(json)
    return factory.create(containerPageData)
}

private fun ClyoScope.containerPageFactory(): ContainerPageFactory {
    return ContainerPageFactory(androidContext, widgetProvider, containerProvider)
}

private fun String.decodeToContainerPage(json: Json): ContainerPageData {
    return json.decodeFromString(this)
}