package com.jlxc.jlhud.model

open class HudElement(
    val id: String,
    var x: Float,
    var y: Float,
    var width: Float,
    var height: Float,
    var rotation: Float = 0f,
    var layer: Int = 0
)
