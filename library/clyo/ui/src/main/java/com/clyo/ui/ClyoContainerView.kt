package com.clyo.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.clyo.data.ClyoData

class ClyoContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes), ClyoComponent {

    override val clyoId: ClyoId = generateClyoId()

    fun render(data: ClyoData) {
        renderView(context, data.content)
    }
}