package com.codeminds.temporaly.feature_auth.presentation.sign_in.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.codeminds.temporaly.R

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 16:57
 */
@Composable
fun FingerprintButton() {
    Box(
        modifier = Modifier
            .size(48.dp)  // Tamaño cuadrado
            .clip(RoundedCornerShape(12.dp))  // Bordes ligeramente redondeados, igual que el botón de "Sign In"
            .background(Color.LightGray)  // Color gris claro
            .clickable { /* Handle Fingerprint Click */ },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_fingerprint),  // Icono de huella dactilar
            contentDescription = "Fingerprint",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}