package com.clyo.android.stub

import com.clyo.android.ClyoData

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