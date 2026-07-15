package com.jlxc.jlhud.editor

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.jlxc.jlhud.model.*

class HudState {
    val elements = mutableStateListOf<HudElement>()

    var selectedId by mutableStateOf<String?>(null)

    fun addText() {
        elements.add(
            HudElement(
                id = "text_${elements.size}",
                type = ElementType.TEXT,
                x = 960f,
                y = 540f,
                width = 300f,
                height = 100f,
                text = "SPEED"
            )
        )
    }

    fun addRectangle() {
        elements.add(
            HudElement(
                id = "rect_${elements.size}",
                type = ElementType.RECTANGLE,
                x = 700f,
                y = 400f,
                width = 500f,
                height = 200f
            )
        )
    }

    fun addIndicator() {
        elements.add(
            HudElement(
                id = "indicator_${elements.size}",
                type = ElementType.INDICATOR,
                x = 500f,
                y = 500f,
                width = 50f,
                height = 50f
            )
        )
    }
}
