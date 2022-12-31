package com.clyo.core

import com.clyo.core.data.WidgetData

abstract class ClyoRenderer<Widget> {
    abstract fun render(data: WidgetData): Widget
}