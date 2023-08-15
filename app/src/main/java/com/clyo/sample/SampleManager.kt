package com.clyo.sample

private val pageJson = """
{
    "content": {
        "#container": "column",
        "content": [
            {
                "#widget": "text",
                "text": "Hello, world!"
            }
        ]
    }
}
""".trimIndent()

internal object SampleManager {

    fun getPageJson(): String = pageJson
}