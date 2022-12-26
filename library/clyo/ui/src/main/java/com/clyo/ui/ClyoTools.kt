package com.clyo.ui

import java.util.UUID

internal object ClyoTools {
    fun generateClyoId(): ClyoId = UUID.randomUUID().toString()
}