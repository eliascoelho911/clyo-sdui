package com.clyo.core.data.kotlinx.serialization.stub

import com.clyo.data.kotlinx.serialization.ScreenData

internal object ScreenDataStub {

    val jsonValue = """
        {
            "content": ${LayoutDataStub.jsonValue}
        }
    """.trimIndent()

    val screenData = ScreenData(
        content = LayoutDataStub.layoutData
    )
}