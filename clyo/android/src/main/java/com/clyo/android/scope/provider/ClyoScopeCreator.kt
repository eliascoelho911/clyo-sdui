package com.clyo.android.scope.provider

import android.content.Context
import com.clyo.android.ClyoApplication
import com.clyo.android.scope.ClyoScope
import com.clyo.android.page.PageFactory

internal fun createClyo(context: Context): ClyoScope = ClyoScope(
    context,
    pageFactory = PageFactory(
        widgetProvider = ClyoApplication.widgetProvider,
        containerProvider = ClyoApplication.containerProvider
    )
)