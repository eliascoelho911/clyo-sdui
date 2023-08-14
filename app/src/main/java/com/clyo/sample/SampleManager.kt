package com.clyo.sample

private val pageJson = """
{
    "content": {
        "type": "column",
        "content": [
            {
                "type": "text",
                "properties": {
                    "text": "Hello, world!"
                }
            }
        ]
    }
}
""".trimIndent()

internal object SampleManager {

    fun getPageJson(): String = pageJson
}