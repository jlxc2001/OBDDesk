package com.jlxc.jlhud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.jlxc.jlhud.JLHudApp

class MainActivity: ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).hide(
            WindowInsetsCompat.Type.systemBars()
        )

        setContent {
            JLHudApp()
        }
    }
}
