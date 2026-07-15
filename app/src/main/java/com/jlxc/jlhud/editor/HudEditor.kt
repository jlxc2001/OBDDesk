package com.jlxc.jlhud.editor

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.jlxc.jlhud.model.*

@Composable
fun HudEditor() {

    val elements = remember {
        mutableStateListOf<HudElement>()
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                "JLHUD Editor v0.4.1",
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = {
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
            ) {
                Text("+")
            }
        }

        Canvas(
            Modifier.fillMaxSize()
        ) {

            val scale = minOf(
                size.width / 1920f,
                size.height / 1080f
            )

            val w = 1920f * scale
            val h = 1080f * scale

            val left = (size.width - w) / 2
            val top = (size.height - h) / 2

            drawRect(
                Color.Black,
                Offset(left, top),
                Size(w, h)
            )

            elements.forEach { e ->

                if (e.type == ElementType.TEXT) {
                    drawContext.canvas.nativeCanvas.apply {
                        val paint = android.graphics.Paint().apply {
                            color = android.graphics.Color.CYAN
                            textSize = 80f * scale
                        }
                        drawText(
                            e.text,
                            left + e.x * scale,
                            top + e.y * scale,
                            paint
                        )
                    }
                }

                if (e.selected) {
                    drawRect(
                        Color.Cyan,
                        Offset(
                            left + e.x * scale - 5,
                            top + e.y * scale - 5
                        ),
                        Size(
                            e.width * scale,
                            e.height * scale
                        ),
                        style = Stroke(3f)
                    )
                }
            }
        }
    }
}
