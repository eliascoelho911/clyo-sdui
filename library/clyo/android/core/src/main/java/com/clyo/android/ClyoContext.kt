package com.clyo.android

import com.clyo.android.component.container.ContainerFactory
import com.clyo.android.component.widget.WidgetFactory

interface ClyoContext

fun ClyoContext.clyo(clyoDeclarations: ClyoDeclarations = emptyClyoDeclarations()): Lazy<ClyoEngine> =
    lazy {
        ClyoEngine(
            clyoRenderer = ClyoRenderer(
                widgetFactory = WidgetFactory(clyoDeclarations),
                containerFactory = ContainerFactory(clyoDeclarations)
            )
        )
    }