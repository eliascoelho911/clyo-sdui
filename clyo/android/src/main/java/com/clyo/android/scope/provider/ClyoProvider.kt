package com.clyo.android.scope.provider

import com.clyo.android.ClyoApplication
import com.clyo.android.scope.Clyo
import com.clyo.android.page.PageRenderer

internal fun createClyo(): Clyo = Clyo(
    pageRenderer = PageRenderer(
        widgetProvider = ClyoApplication.widgetProvider,
        containerProvider = ClyoApplication.containerProvider
    )
)