package com.eliascoelho911.clyo.android.components

import androidx.annotation.StyleRes
import com.eliascoelho911.clyo.core.ui.action.Action
import com.eliascoelho911.clyo.core.ui.component.BindProperty
import com.eliascoelho911.clyo.core.ui.component.Component

data class Button(
    @BindProperty("text")
    val text: String,
    @BindProperty("style")
    @StyleRes
    val styleRes: Int,
    override val onClickActions: List<Action>
): Component()