package com.codeminds.temporaly.feature_auth.presentation.sign_up.render

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
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme
import com.codeminds.temporaly.feature_auth.presentation.shared.components.SocialMediaLoginOptions
import com.codeminds.temporaly.feature_auth.presentation.sign_up.components.TitleSection
import com.codeminds.temporaly.feature_auth.presentation.sign_up.components.InputFields
import com.codeminds.temporaly.feature_auth.presentation.sign_up.components.LoginNowText
import com.codeminds.temporaly.feature_auth.presentation.sign_up.components.SignUnButton

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 27/09/24 @ 00:58
 */
@Composable
fun SignUpScreen(viewModel: SignUpViewModel = hiltViewModel()) {

    val signUpState = viewModel.state.collectAsState().value
    val showDialog = remember { mutableStateOf(false) }

    if (signUpState.error.isNotBlank()) {
        showDialog.value = true
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Error") },
            text = { Text(text = signUpState.error ?: "Unknown error") },
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

    if (signUpState.data != null && signUpState.success) {
        val context = LocalContext.current
        LaunchedEffect(signUpState.data) {
            Toast.makeText(context, "Registration was successful", Toast.LENGTH_LONG).show()
        }
        viewModel.clearError()
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(TemporalyTheme.dimens.paddingMedium)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (signUpState.isLoading) {
            CircularProgressIndicator()
        } else {
            TitleSection()
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
            InputFields(viewModel)
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
            SignUnButton(onClick = {
                viewModel.signUp()
            })
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
            SocialMediaLoginOptions()
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
            LoginNowText {
            }
        }
    }
}