package com.clyo.global

import java.util.UUID

internal object ClyoExternalTools {
    fun generateClyoId(): ClyoId = UUID.randomUUID().toString()
}