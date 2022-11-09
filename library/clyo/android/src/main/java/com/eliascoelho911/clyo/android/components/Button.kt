package com.eliascoelho911.clyo.android.components

import androidx.annotation.StyleRes
import com.eliascoelho911.clyo.core.component.Component
import com.eliascoelho911.clyo.core.component.ComponentFactory
import com.eliascoelho911.clyo.core.data.component.BindProperty
import com.eliascoelho911.clyo.core.data.component.ComponentData
import com.eliascoelho911.clyo.core.data.component.DeclareComponent

@DeclareComponent("android.button")
data class Button(
    @BindProperty("text")
    val text: String,
    @BindProperty("style")
    @StyleRes
    val styleRes: Int
) : Component()

class ButtonFactory : ComponentFactory<Button> {
    override fun create(data: ComponentData): Button {
        return Button(
            text = data.getPropertyByKey("text"),
            styleRes = data.getPropertyByKey("style")
        )
    }
}