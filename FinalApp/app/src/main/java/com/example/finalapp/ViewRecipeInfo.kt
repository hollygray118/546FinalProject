package com.example.finalapp

import android.widget.PopupWindow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ViewRecipeInfo(r: Recipe) {
    var exit = false
    while(!exit) {
//        Column(
//            modifier = Modifier
//                .padding(20.dp)
//                .fillMaxSize()
//        ) {
//           AsyncImage(model = r.image, contentDescription = "Recipe Image")
//            Button(onClick = { exit = true }) { Text("View Less")}
//        }
        PopupWindow(400, 100)
    }
}