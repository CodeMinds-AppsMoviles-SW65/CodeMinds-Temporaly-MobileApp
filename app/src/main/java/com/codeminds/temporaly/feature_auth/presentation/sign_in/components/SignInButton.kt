package com.codeminds.temporaly.feature_auth.presentation.sign_in.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 16:23
 */
@Composable
fun SignInButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primary)
            .clickable {

            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Sign In",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}