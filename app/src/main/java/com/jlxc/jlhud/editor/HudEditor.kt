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
import androidx.compose.ui.unit.dp
import com.jlxc.jlhud.model.ElementType

@Composable
fun HudEditor() {
    val state = remember { HudState() }

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
                "JLHUD Editor v0.3",
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )

            Row {
                Button(onClick = { state.addText() }) {
                    Text("Text")
                }
                Button(onClick = { state.addRectangle() }) {
                    Text("Rect")
                }
                Button(onClick = { state.addIndicator() }) {
                    Text("LED")
                }
            }
        }

        Canvas(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
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

            state.elements.forEach { e ->
                val x = left + e.x * scale
                val y = top + e.y * scale

                when(e.type) {
                    ElementType.RECTANGLE ->
                        drawRect(
                            Color(0x5539C5BB),
                            Offset(x, y),
                            Size(e.width * scale, e.height * scale)
                        )

                    ElementType.INDICATOR ->
                        drawCircle(
                            Color.Green,
                            radius = e.width * scale / 2,
                            center = Offset(x, y)
                        )

                    ElementType.TEXT ->
                        drawCircle(
                            Color.Cyan,
                            radius = 5f,
                            center = Offset(x, y)
                        )
                }
            }
        }
    }
}
