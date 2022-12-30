package com.clyo.android.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.clyo.android.ClyoAndroid
import com.clyo.core.data.ClyoData

class ClyoContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var clyoAndroid: ClyoAndroid? = null

    fun render(data: ClyoData) {
        clyoAndroid?.let { addView(it.render(data.content)) }
    }
}