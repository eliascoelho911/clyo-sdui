package com.clyo.android

import com.clyo.android.component.ComponentModule
import com.clyo.android.component.emptyComponentModule

class ClyoComponents internal constructor(
    val componentModule: ComponentModule = emptyComponentModule()
)

fun emptyClyoComponents() = ClyoComponents()