package com.demo.synetest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopTitle(title: String, isShow: Boolean/*, onClick: () -> Unit*/) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(isShow)
            IconButton(onClick = {
    //            onClick()
            }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        Text(
            title, color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
        )
    }
}


@Composable
fun LabelText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp
    )
}

@Composable
fun ValueText(text: String) {
    Text(
        text = text.capitalizeWords(),
        fontWeight = FontWeight.ExtraBold,
        color = Color.DarkGray,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp
    )
}

@Composable
fun Loader(){
    // Indeterminate
    CircularProgressIndicator()

}

