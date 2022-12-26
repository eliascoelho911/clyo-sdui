package com.clyo.ui

internal object ClyoApplication {
    fun getOrCreate(clyoId: ClyoId): Clyo {
        return ClyoFactory.getOrCreate(clyoId)
    }
}