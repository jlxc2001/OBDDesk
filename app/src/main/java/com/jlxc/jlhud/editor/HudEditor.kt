package com.jlxc.jlhud.editor

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HudEditor() {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "JLHUD Editor v0.1",
            modifier = Modifier.padding(16.dp)
        )

        Canvas(
            Modifier.fillMaxSize()
        ) {
            val scale = minOf(size.width / 1920f, size.height / 1080f)
            drawRect(
                color = Color.Black,
                size = Size(1920f * scale, 1080f * scale)
            )
        }
    }
}
