package com.eliascoelho911.clyo.android.components

import android.content.Context
import android.widget.Button
import androidx.annotation.StyleRes
import com.clyo.core.android.ComponentView
import com.clyo.core.android.ComponentViewCreator
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

object ButtonViewCreator : ComponentViewCreator<ButtonData> {
    override fun create(context: Context, data: ButtonData): ComponentView {
        return Button(context).apply {
            text = data.text
        }
    }
}