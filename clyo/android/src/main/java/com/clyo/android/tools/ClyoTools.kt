package com.clyo.android.tools

import android.content.Context
import com.clyo.android.ui.Container
import com.clyo.data.container.ContainerJson
import kotlinx.serialization.json.Json

internal data class ClyoTools(
    private val containerFactory: ContainerFactory,
    private val json: Json
) {
    fun createContainer(context: Context, json: ContainerJson): Container<*> {
        return containerFactory.create(context, json)
    }
}