package com.clyo.android.tools

import com.clyo.android.ClyoApplication
import kotlinx.serialization.json.Json

data class ClyoTools internal constructor(
    val containerFactory: ContainerFactory,
    val json: Json
)

internal fun tools() = ClyoApplication.tools()