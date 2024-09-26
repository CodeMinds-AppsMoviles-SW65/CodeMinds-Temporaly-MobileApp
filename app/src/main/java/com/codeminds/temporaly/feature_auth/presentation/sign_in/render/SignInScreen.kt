package com.codeminds.temporaly.feature_auth.presentation.sign_in.render

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.ForgotPasswordText
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.InputFields
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.RegisterNowText
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.SignInButton
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.SignInButtonWithFingerprint
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.SocialMediaLoginOptions
import com.codeminds.temporaly.feature_auth.presentation.sign_in.components.TitleSection

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 15:40
 */
@Composable
fun SignInScreen(viewModel: SignInViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleSection()
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
        InputFields()
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        ForgotPasswordText()
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        SignInButtonWithFingerprint()
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
        SocialMediaLoginOptions()
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))
        RegisterNowText()
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    TemporalyTheme {
        SignInScreen()
    }
}