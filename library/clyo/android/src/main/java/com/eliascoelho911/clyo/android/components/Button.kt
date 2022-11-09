package com.eliascoelho911.clyo.android.components

import androidx.annotation.StyleRes
import com.eliascoelho911.clyo.core.component.Component
import com.eliascoelho911.clyo.core.component.ComponentProvider
import com.eliascoelho911.clyo.core.data.ComponentData

data class Button(
    val text: String,
    @StyleRes
    val styleRes: Int
) : Component()

object ButtonProvider: ComponentProvider<Button> {
    override fun provide(data: ComponentData): Button {
        return Button(
            text = data.getPropertyByKey("text"),
            styleRes = data.getPropertyByKey("style")
        )
    }
}
