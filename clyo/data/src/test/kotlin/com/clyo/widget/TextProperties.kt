package com.clyo.widget

import kotlinx.serialization.Serializable

@Serializable
internal data class TextProperties(
    val text: String
) : Properties()