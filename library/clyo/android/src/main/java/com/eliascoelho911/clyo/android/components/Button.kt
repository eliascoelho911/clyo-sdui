package com.eliascoelho911.clyo.android.components

import androidx.annotation.StyleRes
import com.eliascoelho911.clyo.component.Component
import com.eliascoelho911.clyo.component.ComponentProvider
import com.eliascoelho911.clyo.data.ComponentDataContract

data class Button(
    val text: String,
    @StyleRes
    val styleRes: Int?
) : Component()

object ButtonProvider : ComponentProvider<Button> {
    override fun provide(data: ComponentDataContract): Button {
        return Button(
            text = data.properties["text"]?.contentOrNull.orEmpty(),
            styleRes = data.properties["style"]?.intOrNull
        )
    }
}
