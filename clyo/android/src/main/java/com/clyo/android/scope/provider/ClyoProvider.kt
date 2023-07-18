package com.clyo.android.scope.provider

import com.clyo.android.ClyoApplication
import com.clyo.android.scope.Clyo
import com.clyo.android.ui.page.PageFactory

internal fun createClyo(): Clyo = Clyo(
    pageFactory = PageFactory(
        widgetProvider = ClyoApplication.widgetProvider,
        containerProvider = ClyoApplication.containerProvider
    ),
    json = ClyoApplication.json
)