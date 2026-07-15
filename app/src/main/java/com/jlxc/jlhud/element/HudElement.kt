package com.jlxc.jlhud.element

import com.jlxc.jlhud.model.Style
import com.jlxc.jlhud.model.Transform

enum class ElementType {
    TEXT,
    RECTANGLE,
    INDICATOR
}

open class HudElement(
    val id:String,
    val type:ElementType,
    var transform:Transform = Transform(),
    var style:Style = Style()
)
