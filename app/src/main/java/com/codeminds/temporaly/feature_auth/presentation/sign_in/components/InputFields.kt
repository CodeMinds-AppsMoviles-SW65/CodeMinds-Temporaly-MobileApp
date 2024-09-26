package com.codeminds.temporaly.feature_auth.presentation.sign_in.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.codeminds.temporaly.R

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 16:13
 */
@Composable
fun InputFields() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                "Email"
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_mail),
                contentDescription = "Email Icon",
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                "Password",
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = "Password Icon"
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}