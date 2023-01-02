package com.clyo.core

interface ClyoApplication {
    fun createClyo(): Clyo

    fun stop()
}