package com.eliascoelho911.notate.clyo.core.ui.component

import androidx.annotation.StyleRes
import com.eliascoelho911.notate.clyo.core.ui.action.Action

data class Button(
    @BindProperty("text")
    val text: String,
    @BindProperty("style")
    @StyleRes
    val styleRes: Int,
    override val onClickActions: List<Action>
): Component()