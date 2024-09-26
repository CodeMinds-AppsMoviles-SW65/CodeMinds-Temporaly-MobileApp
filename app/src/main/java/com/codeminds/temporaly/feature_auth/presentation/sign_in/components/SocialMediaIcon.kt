package com.codeminds.temporaly.feature_auth.presentation.sign_in.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 16:34
 */
@Composable
fun SocialMediaIcon(iconRes: Int) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(TemporalyTheme.dimens.iconSizeNormal)
            .clip(CircleShape)
            .clickable {
                // Handle social media login click
            }
    )
}