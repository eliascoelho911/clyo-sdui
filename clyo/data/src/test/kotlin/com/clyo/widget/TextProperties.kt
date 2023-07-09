package com.clyo.widget

import com.clyo.data.properties.Properties
import kotlinx.serialization.Serializable

@Serializable
internal data class TextProperties(
    val text: String
) : Properties()