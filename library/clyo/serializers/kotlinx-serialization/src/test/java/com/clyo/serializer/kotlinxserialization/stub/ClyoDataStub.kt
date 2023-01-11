package com.clyo.serializer.kotlinxserialization.stub

import com.clyo.serializer.kotlinxserialization.ClyoData

internal object ClyoDataStub {

    val jsonValue = """
        {
            "container": ${ComponentDataStub.jsonValue}
        }
    """.trimIndent()

    val clyoData = ClyoData(
        root = ComponentDataStub.componentData
    )
}