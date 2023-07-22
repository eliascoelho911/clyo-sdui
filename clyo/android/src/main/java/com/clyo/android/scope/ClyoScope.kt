package com.clyo.android.scope

import android.content.Context
import com.clyo.android.page.Page
import com.clyo.android.page.PageData
import com.clyo.android.page.PageFactory

class ClyoScope internal constructor(
    private val context: Context,
    private val pageFactory: PageFactory
) {
    fun page(pageData: PageData): Page {
        return pageFactory.create(context, pageData)
    }
}