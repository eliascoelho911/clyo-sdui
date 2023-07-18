package com.clyo.stubs

import com.clyo.data.PageJson

internal object ClyoPageJsonStub {
    val clyoPage = PageJson(
        content = BoxContainerStub.containerJson,
        properties = PropertiesJsonStub.propertiesJson
    )
}