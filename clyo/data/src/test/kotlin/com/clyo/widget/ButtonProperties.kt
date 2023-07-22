package com.clyo.widget

import kotlinx.serialization.Serializable

@Serializable
internal data class ButtonProperties(
    val text: String,
    val isDisabled: Boolean
) : Properties()