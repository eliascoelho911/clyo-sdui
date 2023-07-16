package com.clyo.stubs

import com.clyo.data.ClyoPageJson

internal object ClyoPageJsonStub {
    val clyoPage = ClyoPageJson(
        content = BoxContainerStub.containerJson,
        properties = PropertiesJsonStub.propertiesJson
    )
}