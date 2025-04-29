package com.example.finalapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsPage()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .height(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Settings Screen",
            color = Color.White,
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 55.dp)
            .height(100.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "About the App",
            modifier = Modifier.padding(top = 2.dp),
            color = Color.DarkGray,
            fontSize = 20.sp
        )
        Text(
            text = "\nThis app was designed and developed by Holly Gray for CSCE 546, Mobile Application Development, at the University of South Carolina.",
            color = Color.DarkGray
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}
