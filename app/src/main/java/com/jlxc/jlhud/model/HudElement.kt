package com.jlxc.jlhud.model

import androidx.compose.ui.graphics.Color

enum class ElementType {
    TEXT,
    RECTANGLE,
    INDICATOR
}

data class HudElement(
    val id:String,
    val type:ElementType,
    var x:Float,
    var y:Float,
    var width:Float,
    var height:Float,
    var text:String = "",
    var color:Color = Color.Cyan,
    var selected:Boolean = false
)
