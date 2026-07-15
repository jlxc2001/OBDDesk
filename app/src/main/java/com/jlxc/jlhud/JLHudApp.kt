package com.jlxc.jlhud

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

data class HudItem(
 var type:String,
 var x:Float=960f,
 var y:Float=540f,
 var text:String="SPEED",
 var color:Color=Color.Cyan
)

@Composable
fun JLHudApp(){

 val items=remember{mutableStateListOf<HudItem>()}
 var selected by remember{mutableStateOf<HudItem?>(null)}

 Row(Modifier.fillMaxSize().background(Color(0xff101010))){

  Column(Modifier.width(180.dp).fillMaxHeight()){
   Text("Elements",color=Color.White)

   Button(onClick={
    items.add(HudItem("TEXT"))
   }){
    Text("Text")
   }

   Button(onClick={
    items.add(HudItem("RECT"))
   }){
    Text("Rect")
   }

   Button(onClick={
    items.add(HudItem("LED"))
   }){
    Text("LED")
   }

   items.forEach{
    Text(it.type,color=if(it==selected)Color.Cyan else Color.White)
   }
  }


  Box(
   Modifier.weight(1f).fillMaxHeight()
  ){

   Canvas(
    Modifier
     .fillMaxSize()
     .pointerInput(Unit){
      detectDragGestures(
       onDragStart={
        if(items.isNotEmpty()) selected=items.last()
       },
       onDrag={_,drag->
        selected?.let{
         it.x+=drag.x
         it.y+=drag.y
        }
       }
      )
     }
   ){

    drawRect(Color.Black)

    items.forEach{

     when(it.type){
      "RECT"->drawRect(
       it.color,
       Offset(it.x,it.y),
       Size(300f,100f)
      )

      "LED"->drawCircle(
       it.color,
       30f,
       Offset(it.x,it.y)
      )

      else->{
       drawCircle(
        it.color,
        8f,
        Offset(it.x,it.y)
       )
      }
     }
    }

    selected?.let{
     drawRect(
      Color.Blue,
      Offset(it.x-50,it.y-50),
      Size(100f,100f),
      style=androidx.compose.ui.graphics.drawscope.Stroke(3f)
     )
    }
   }
  }


  Column(Modifier.width(260.dp)){
   Text("Properties",color=Color.White)
   selected?.let{
    Text("Type ${it.type}",color=Color.White)
    Text("X ${it.x}",color=Color.White)
    Text("Y ${it.y}",color=Color.White)
   }
  }
 }
}
