package com.clyo.core.global

import com.clyo.core.data.WidgetData

/**
 * Importante abstração para permitir a integração com KMM
 */
abstract class ClyoApplication<Widget> {
    private val clyoId: ClyoId = ClyoExternalTools.generateClyoId()

    abstract fun render(data: WidgetData): Widget
}