package com.clyo.android.common

import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.clyo.android.common.newInstance
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KClassExtensionsKtTest {
    private val context = getInstrumentation().targetContext

    @Test
    fun shouldCreateView() {
        val view = View::class.newInstance(context)

        assertNotNull(view)
    }
}