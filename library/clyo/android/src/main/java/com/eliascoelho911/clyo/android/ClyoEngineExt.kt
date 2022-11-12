package com.eliascoelho911.clyo.android

import androidx.appcompat.app.AppCompatActivity
import com.eliascoelho911.clyo.ClyoEngine
import com.eliascoelho911.clyo.getClyoEngine

fun AppCompatActivity.androidClyoEngine(): Lazy<ClyoEngine> = lazy {
    getClyoEngine()
}