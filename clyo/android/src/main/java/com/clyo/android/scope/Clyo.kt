package com.clyo.android.scope

import android.content.Context
import com.clyo.android.page.Page
import com.clyo.android.page.PageRenderer
import com.clyo.android.data.PageData

class Clyo internal constructor(
    private val pageRenderer: PageRenderer
) {
    fun page(context: Context, pageData: PageData): Page {
        return pageRenderer.create(context, pageData)
    }
}