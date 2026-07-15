package com.jlxc.jlhud

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class HudItem(
    var type: String,
    var x: Float = 960f,
    var y: Float = 540f
)

@Composable
fun JLHudApp() {

    val items = remember { mutableStateListOf<HudItem>() }

    Row(
        Modifier
            .fillMaxSize()
            .background(Color(0xff101010))
    ) {

        Column(
            Modifier.width(180.dp)
        ) {
            Text("Elements", color = Color.White)

            Button(
                onClick = {
                    items.add(HudItem("TEXT"))
                }
            ) {
                Text("Add Text")
            }

            Button(
                onClick = {
                    items.add(HudItem("RECT"))
                }
            ) {
                Text("Add Rect")
            }
        }

        Canvas(
            Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {

            drawRect(Color.Black)

            items.forEach { item ->
                when(item.type) {
                    "RECT" -> drawRect(
                        Color.Cyan,
                        Offset(item.x, item.y),
                        Size(300f,100f)
                    )
                    else -> drawCircle(
                        Color.Cyan,
                        8f,
                        Offset(item.x,item.y)
                    )
                }
            }
        }

        Column(
            Modifier.width(240.dp)
        ) {
            Text(
                "Properties",
                color = Color.White
            )
        }
    }
}
