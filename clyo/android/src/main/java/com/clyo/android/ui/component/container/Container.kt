package com.clyo.android.ui.component.container

import com.clyo.android.ui.component.Component
import com.clyo.android.ui.component.widget.Widget

interface Container : Component {

    val content: List<Widget<*, *>>

    /**
     * This method is responsible for just displaying the content, without any properties assigned.
     */
    fun showContent()
}