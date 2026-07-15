package com.jlxc.jlhud.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import com.jlxc.jlhud.element.*

@Composable
fun HudRenderer(
    modifier: Modifier = Modifier,
    elements: List<HudElement>
){

    Canvas(modifier){

        val scale=minOf(size.width/1920f,size.height/1080f)

        drawRect(
            Color.Black,
            size=Size(1920f*scale,1080f*scale)
        )

        elements.forEach { e ->

            when(e.type){

                ElementType.RECTANGLE ->
                    drawRect(
                        e.style.color,
                        size=Size(
                            e.transform.width*scale,
                            e.transform.height*scale
                        )
                    )

                ElementType.INDICATOR ->
                    drawCircle(
                        e.style.color,
                        radius=e.transform.width*scale/2
                    )

                else -> {}

            }
        }
    }
}
