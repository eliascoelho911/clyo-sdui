package com.clyo.core.data.stub

import com.clyo.core.data.kotlinx.serialization.data.ScreenDataKS

internal object ScreenDataKSStub {

    val jsonValue = """
        {
            "content": ${LayoutDataKSStub.jsonValue}
        }
    """.trimIndent()

    val screenDataKS = ScreenDataKS(
        content = LayoutDataKSStub.layoutDataKS
    )
}