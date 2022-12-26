package com.clyo.ui

internal interface ClyoComponent {
    val clyoId: ClyoId

    val clyo: Clyo get() = ClyoApplication.getOrCreate(clyoId)

    fun generateClyoId(): ClyoId {
        return ClyoTools.generateClyoId()
    }
}