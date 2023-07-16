package com.clyo.android.ui.page

import android.view.ViewGroup

fun ViewGroup.show(page: ClyoPage) {
    addView(page.containerRoot.view)
}

//Step atual: Pegar ClyoScope
fun ClyoPage.renderContent() {
    val json = ClyoScope.json

    content.forEach { widget ->
        val properties = propertiesJson.decodeProperties(json, widget.id)
        widget.render(properties)
    }
}