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
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    fun submitData(data: ClyoData) {
        findClyoEngine()
    }
}