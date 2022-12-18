package com.eliascoelho911.clyo.sample.data.service

import com.clyo.data.kotlinx.serialization.ScreenData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private const val SCREEN_CONTENT_PATH = "screen_content.json"

internal class GetClyoSampleScreenContent {
    operator fun invoke(): com.clyo.data.ScreenData {
        val jsonContent = readContent()
        return Json.decodeFromString<ScreenData>(jsonContent)
    }

    private fun readContent(): String =
        this::class.java.classLoader!!.getResource(SCREEN_CONTENT_PATH)!!.readText(Charsets.UTF_8)
}