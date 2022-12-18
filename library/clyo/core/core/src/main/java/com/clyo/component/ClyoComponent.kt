package com.clyo.component

import com.clyo.Clyo
import com.clyo.ClyoTools

/**
 * Feito para criação de extensions para Clyo.
 */
interface ClyoComponent {
    fun getClyo(): Clyo = ClyoTools.clyo()
}
