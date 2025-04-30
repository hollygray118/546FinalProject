package com.example.finalapp

import android.widget.PopupWindow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlin.system.exitProcess

@Composable
fun ViewRecipeInfo(r: Recipe, exit: Boolean) {
    while(exit) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .height(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bookmarks Screen",
                color = Color.White,
            )
        }
        Box(
            modifier = Modifier.fillMaxSize().background(Color.DarkGray)
        ) {
            ElevatedButton(onClick = { exitProcess(0) }) { Text("View Less") }
        }
    }
}