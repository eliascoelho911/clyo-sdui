package com.clyo.ui

internal object ClyoFactory {
    private val clyoInstanceCache = ClyoInstanceCache()

    fun getOrCreate(clyoId: ClyoId): Clyo {
        return get(clyoId) ?: run {
            create(clyoId)
        }
    }

    private fun get(clyoId: ClyoId): Clyo? {
        return clyoInstanceCache[clyoId]
    }

    private fun create(clyoId: ClyoId): Clyo {
        return Clyo().also {
            clyoInstanceCache[clyoId] = it
        }
    }
}