package com.codeminds.temporaly.feature_about_us.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsHeader(fontFamily: FontFamily) {
    TopAppBar(
        title = {
            Text(
                text = "Privacy Policy",
                color = Color.White,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 26.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* Acción de retroceso aquí */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFF2979FF)
        )
    )
}
