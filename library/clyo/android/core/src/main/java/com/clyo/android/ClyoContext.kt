package com.clyo.android

import com.clyo.android.component.container.ContainerFactory
import com.clyo.android.component.widget.WidgetFactory

interface ClyoContext

fun ClyoContext.clyo(clyoComponents: ClyoComponents = emptyClyoComponents()): Lazy<ClyoEngine> =
    lazy {
        ClyoEngine(
            clyoRenderer = ClyoRenderer(
                widgetFactory = WidgetFactory(clyoComponents.componentModule),
                containerFactory = ContainerFactory(clyoComponents.componentModule)
            )
        )
    }