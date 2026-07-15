package com.jlxc.jlhud.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jlxc.jlhud.canvas.HudRenderer

@Composable
fun HudEditorScreen(){

    Row(
        Modifier
            .fillMaxSize()
            .background(Color(0xff101010))
    ){

        Column(
            Modifier.width(160f)
        ){
            Text("Elements",color=Color.White)
        }

        HudRenderer(
            Modifier.weight(1f)
        )

        Column(
            Modifier.width(260f)
        ){
            Text("Properties",color=Color.White)
        }
    }
}
