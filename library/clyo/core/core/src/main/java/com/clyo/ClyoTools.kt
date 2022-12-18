package com.clyo

internal object ClyoTools {
    fun clyo(): Clyo = ClyoProvider.getOrCreate()
}