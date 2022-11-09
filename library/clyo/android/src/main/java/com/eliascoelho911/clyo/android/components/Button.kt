package com.eliascoelho911.clyo.android.components

import androidx.annotation.StyleRes
import com.eliascoelho911.clyo.core.component.Component

data class Button(
    val text: String,
    @StyleRes
    val styleRes: Int
) : Component()
