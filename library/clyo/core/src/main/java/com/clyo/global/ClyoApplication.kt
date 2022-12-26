package com.clyo.global

import com.clyo.data.ViewData

/**
 * Importante abstração para permitir a integração com KMM
 */
internal abstract class ClyoApplication<WidgetType> {
    private val clyoId: ClyoId = ClyoExternalTools.generateClyoId()

    abstract fun render(data: ViewData): WidgetType
}