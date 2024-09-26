package com.codeminds.temporaly.feature_auth.presentation.sign_in.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codeminds.temporaly.R
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 16:33
 */
@Composable
fun SocialMediaLoginOptions() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(modifier = Modifier.weight(1f), color = Color.Gray)
        Text(
            text = "Or continue with",
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.secondary,
        )
        Divider(modifier = Modifier.weight(1f), color = Color.Gray)
    }

    Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerLarge))

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        SocialMediaIcon(iconRes = R.drawable.ic_facebook)
        Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerMedium))
        SocialMediaIcon(iconRes = R.drawable.ic_google)
        Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerMedium))
        SocialMediaIcon(iconRes = R.drawable.ic_github)
    }
}