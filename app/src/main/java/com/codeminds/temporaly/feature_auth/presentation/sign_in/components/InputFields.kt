package com.codeminds.temporaly.feature_auth.presentation.sign_in.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.codeminds.temporaly.R
import com.codeminds.temporaly.feature_auth.presentation.sign_in.render.SignInViewModel

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 16:13
 */
@Composable
fun InputFields(viewModel: SignInViewModel) {
    OutlinedTextField(
        value  = viewModel.email.collectAsState().value,
        textStyle = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Start),
        onValueChange = {
            viewModel.onEmailChanged(it)
        },
        label = {
            Text(
                "Email",
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
        value = viewModel.password.collectAsState().value,
        textStyle = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Start),
        onValueChange = {
            viewModel.onPasswordChanged(it)
        },
        label = {
            Text(
                "Password",
            )
        },
        visualTransformation =  PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = "Password Icon"
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}