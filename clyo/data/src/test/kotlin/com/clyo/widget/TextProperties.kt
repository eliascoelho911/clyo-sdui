package com.clyo.widget

import com.clyo.data.widget.WidgetProperties
import kotlinx.serialization.Serializable

@Serializable
internal data class TextProperties(
    val text: String
) : WidgetProperties()