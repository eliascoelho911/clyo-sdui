package com.eliascoelho911.clyo.android.components

import androidx.annotation.StyleRes
import com.eliascoelho911.clyo.data.component.ComponentData
import com.eliascoelho911.clyo.data.component.ComponentDataContract
import com.eliascoelho911.clyo.data.component.ComponentDataCreator

data class ButtonData(
    val text: String,
    @StyleRes
    val styleRes: Int?
) : ComponentData()

object ButtonDataCreator : ComponentDataCreator<ButtonData> {
    override fun create(data: ComponentDataContract): ButtonData {
        return ButtonData(
            text = data.properties["text"]?.contentOrNull.orEmpty(),
            styleRes = data.properties["style"]?.intOrNull
        )
    }
}