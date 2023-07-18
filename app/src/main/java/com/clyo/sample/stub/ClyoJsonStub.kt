package com.clyo.sample.stub

import com.clyo.data.PageJson
import com.clyo.data.properties.PropertiesJson
import com.clyo.sample.stub.container.ColumnStubs
import com.clyo.sample.stub.widget.ButtonStubs
import com.clyo.sample.stub.widget.TextStubs
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

internal object ClyoJsonStub {
    val json = PageJson(
        content = ColumnStubs.containerJson,
        properties = PropertiesJson(
            JsonObject(
                mapOf(
                    "txt" to Json.decodeFromString(TextStubs.propertiesJsonValue),
                    "btn" to Json.decodeFromString(ButtonStubs.propertiesJsonValue)
                )
            )
        )
    )
}