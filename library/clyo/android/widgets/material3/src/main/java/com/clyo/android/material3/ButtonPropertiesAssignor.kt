package com.clyo.android.material3

import com.clyo.android.properties.PropertiesAssignor
import com.clyo.data.PropertiesData
import com.google.android.material.button.MaterialButton

class ButtonPropertiesAssignor: PropertiesAssignor<MaterialButton> {
    override fun assign(properties: com.clyo.data.PropertiesData, destination: MaterialButton) {
        destination.apply {
            text = properties.getStringOrNull("text")
        }
    }
}