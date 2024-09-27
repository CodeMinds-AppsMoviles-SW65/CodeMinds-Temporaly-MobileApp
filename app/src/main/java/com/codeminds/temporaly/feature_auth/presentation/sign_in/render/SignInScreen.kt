package com.codeminds.temporaly.feature_auth.presentation.sign_in.render

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme
import com.codeminds.temporaly.feature_auth.presentation.shared.components.SocialMediaLoginOptions
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.ForgotPasswordText
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.InputFields
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.RegisterNowText
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.SignInButtonWithFingerprint
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.TitleSection

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 15:40
 */

@Composable
fun SignInScreen(viewModel: SignInViewModel = hiltViewModel()) {

    val signInState = viewModel.state.collectAsState().value
    val showDialog = remember { mutableStateOf(false) }

    if (signInState.error.isNotBlank()) {
        showDialog.value = true
    }

    if (signInState.data != null || signInState.success) {
        val context = LocalContext.current
        val username = signInState.data?.username
        LaunchedEffect(username) {
            Toast.makeText(context, "Welcome $username", Toast.LENGTH_SHORT).show()
        }
        viewModel.clearError()
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Error") },
            text = { Text(text = signInState.error ?: "Unknown error") },
            confirmButton = {
                Button(onClick = {
                    showDialog.value = false
                    viewModel.clearError()
                }) {
                    Text("OK")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(TemporalyTheme.dimens.paddingMedium)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (signInState.isLoading) {
            CircularProgressIndicator()
        } else if (!showDialog.value) {
            TitleSection()
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
            InputFields(viewModel = viewModel)
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
            ForgotPasswordText(onForgotPasswordClick = {

            })
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
            SignInButtonWithFingerprint(
                onFingerprintClick = {
                },
                onClick = {
                    viewModel.signIn()
                })
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
            SocialMediaLoginOptions()
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
            RegisterNowText(onRegisterClick = {
                // viewModel.navigateToRegister()
            })
        }
    }
}
@Preview
@Composable
fun SignInScreenPreview() {
    TemporalyTheme {
        SignInScreen()
    }
}