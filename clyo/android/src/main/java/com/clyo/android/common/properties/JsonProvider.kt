package com.clyo.android.common.properties

import kotlinx.serialization.json.Json

internal interface JsonProvider {

    val json: Json
}