package com.codeminds.temporaly.feature_about_us.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun TeamProfileSection(fontFamily: FontFamily) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Team Profile",
        style = androidx.compose.ui.text.TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    )
    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://i.ibb.co/1mJr2p3/mateo.jpg"),
            contentDescription = "Team Member 1",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Image(
            painter = rememberAsyncImagePainter("https://i.ibb.co/vD9kZkr/abel.jpg"),
            contentDescription = "Team Member 2",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Image(
            painter = rememberAsyncImagePainter("https://i.ibb.co/JWLpkZ0/belen.jpg"),
            contentDescription = "Team Member 3",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Image(
            painter = rememberAsyncImagePainter("https://i.ibb.co/XxXKvWF/alex.jpg"),
            contentDescription = "Team Member 4",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp))
        )
    }

    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "The team is made up of students who are passionate about technology and software development: Mateo Vílchez, Alex Ávila, Belen Ramos, and Abel Ortega.",
        style = androidx.compose.ui.text.TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        )
    )
}
