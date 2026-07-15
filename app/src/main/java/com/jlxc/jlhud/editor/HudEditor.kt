package com.jlxc.jlhud.editor

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
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
                "JLHUD Editor v0.2",
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
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("+")
            }
        }

        Box(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
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
                    topLeft = Offset(left, top),
                    size = Size(w, h)
                )

                elements.forEach {
                    when(it.type) {
                        ElementType.TEXT -> {
                            drawRect(
                                Color.Cyan,
                                Offset(
                                    left + it.x * scale - 5,
                                    top + it.y * scale - 5
                                ),
                                Size(10f,10f)
                            )
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}
