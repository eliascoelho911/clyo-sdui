package com.clyo.android.properties

import com.clyo.android.component.properties.PropertiesData
import com.clyo.android.stub.PropertiesDataStub
import kotlin.test.assertEquals
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class PropertiesDataTest {
    @Test
    fun `Should deserialize PropertiesData`() {
        val deserializedValue = Json.decodeFromString<PropertiesData>(PropertiesDataStub.jsonValue)
        val expected = PropertiesDataStub.propertiesData

        assertEquals(expected, deserializedValue)
    }
}