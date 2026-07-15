package com.jlxc.jlhud.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color

@Composable
fun HudRenderer(modifier: Modifier = Modifier){

    Canvas(modifier){

        val scale=minOf(size.width/1920f,size.height/1080f)

        drawRect(
            color=Color.Black,
            size=Size(1920f*scale,1080f*scale)
        )
    }
}
