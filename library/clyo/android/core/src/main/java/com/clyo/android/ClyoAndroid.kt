package com.clyo.android

import android.content.Context
import com.clyo.android.view.AndroidRegistry
import com.clyo.android.view.ViewBinderInteractor
import com.clyo.android.view.ViewInstantiator
import com.clyo.android.view.ViewRenderer
import com.clyo.core.ClyoApplication

class ClyoAndroid(
    context: Context,
    private val androidRegistry: AndroidRegistry
) : ClyoApplication {
    internal val viewRenderer: ViewRenderer = ViewRenderer(
        context = context,
        viewInstantiator = ViewInstantiator(androidRegistry.viewClassModule),
        viewBinderInteractor = ViewBinderInteractor(androidRegistry.viewBinderModule)
    )
}