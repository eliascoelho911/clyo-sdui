package com.eliascoelho911.clyo.sample.data.service

import com.clyo.android.component.container.template.ClyoTemplateData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private const val TEMPLATE_CONTENT_PATH = "hlist_template.json"

internal class GetClyoTemplateContent {
    operator fun invoke(): ClyoTemplateData {
        val jsonContent = readContent()
        return Json.decodeFromString(jsonContent)
    }

    private fun readContent(): String =
        this::class.java.classLoader!!.getResource(TEMPLATE_CONTENT_PATH)!!.readText(Charsets.UTF_8)
}