package com.clyo.android

import com.clyo.android.component.ComponentModule
import com.clyo.android.component.emptyComponentModule

class ClyoComponents internal constructor(
    val componentModule: ComponentModule = emptyComponentModule()
)

internal fun emptyClyoComponents() = ClyoComponents()