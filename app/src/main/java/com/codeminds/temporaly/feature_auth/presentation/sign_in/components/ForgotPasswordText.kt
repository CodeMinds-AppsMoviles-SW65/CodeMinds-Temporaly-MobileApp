package com.codeminds.temporaly.feature_auth.presentation.sign_in.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 16:19
 */
@Composable
fun ForgotPasswordText() {
    Text(
        text = "Forgot Password?",
        color = MaterialTheme.colorScheme.secondary,
        style = MaterialTheme.typography.headlineSmall,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth().clickable {
            // Handle forgot password click
        }
    )
}