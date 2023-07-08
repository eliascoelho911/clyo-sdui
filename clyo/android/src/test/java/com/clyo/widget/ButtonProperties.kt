package com.clyo.widget

import com.clyo.data.widget.WidgetProperties
import kotlinx.serialization.Serializable

@Serializable
internal data class ButtonProperties(
    val text: String,
    val isDisabled: Boolean
) : WidgetProperties()