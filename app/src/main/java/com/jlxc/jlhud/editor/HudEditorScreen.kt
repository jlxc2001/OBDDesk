package com.jlxc.jlhud.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jlxc.jlhud.canvas.HudRenderer
import com.jlxc.jlhud.element.*

@Composable
fun HudEditorScreen(){

    val elements = remember {
        mutableStateListOf<HudElement>()
    }

    var selected by remember {
        mutableStateOf<String?>(null)
    }

    Row(
        Modifier
            .fillMaxSize()
            .background(Color(0xff101010))
    ){

        Column(
            Modifier
                .width(180.dp)
                .fillMaxHeight()
        ){
            Text(
                "Elements",
                color=Color.White,
                modifier=Modifier.padding(12.dp)
            )

            Button(
                onClick={
                    elements.add(
                        TextElement(
                            "text_${elements.size}"
                        )
                    )
                },
                modifier=Modifier.padding(8.dp)
            ){
                Text("Add Text")
            }

            Button(
                onClick={
                    elements.add(
                        RectangleElement(
                            "rect_${elements.size}"
                        )
                    )
                },
                modifier=Modifier.padding(8.dp)
            ){
                Text("Add Rect")
            }

            Button(
                onClick={
                    elements.add(
                        IndicatorElement(
                            "led_${elements.size}"
                        )
                    )
                },
                modifier=Modifier.padding(8.dp)
            ){
                Text("Add LED")
            }

            elements.forEach {
                Text(
                    text="${it.type} ${it.id}",
                    color=if(selected==it.id) Color.Cyan else Color.White,
                    modifier=Modifier.padding(8.dp)
                )
            }
        }

        HudRenderer(
            modifier=Modifier.weight(1f),
            elements=elements
        )

        Column(
            Modifier
                .width(280.dp)
                .fillMaxHeight()
        ){
            Text(
                "Properties",
                color=Color.White,
                modifier=Modifier.padding(12.dp)
            )

            Text(
                selected ?: "No Selection",
                color=Color.Gray,
                modifier=Modifier.padding(12.dp)
            )
        }
    }
}
