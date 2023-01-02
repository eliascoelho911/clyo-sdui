package com.clyo.android.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.clyo.android.clyoAndroid
import com.clyo.core.ClyoComponent
import com.clyo.core.data.ClyoData

open class ClyoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes), ClyoComponent {

    private val clyo by clyoAndroid()

    fun render(data: ClyoData) {
        clyo.render(data)
    }
}