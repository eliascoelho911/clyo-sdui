package com.clyo.data.kotlinx.serialization.stub

import com.clyo.data.kotlinx.serialization.ClyoData

internal object ScreenDataStub {

    val jsonValue = """
        {
            "content": ${LayoutDataStub.jsonValue}
        }
    """.trimIndent()

    val screenData = ClyoData(
        content = LayoutDataStub.viewData
    )
}