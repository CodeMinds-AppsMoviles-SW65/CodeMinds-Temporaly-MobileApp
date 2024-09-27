package com.codeminds.temporaly.feature_auth.presentation.sign_up.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 16:06
 */
@Composable
fun TitleSection() {
    Text(
        text = "Sign Up",
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 24.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth()
    )
    Text(
        text = "Please enter your details below to create your account and start enjoying the app.",
        fontSize = 14.sp,
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.secondary,
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
    )
}