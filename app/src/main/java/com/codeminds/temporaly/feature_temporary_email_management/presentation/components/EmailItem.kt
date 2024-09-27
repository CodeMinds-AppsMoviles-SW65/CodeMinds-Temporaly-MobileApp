package com.codeminds.temporaly.feature_temporary_email_management.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeminds.temporaly.R
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme


data class EmailItem(
    val emailStatus: Boolean,
    val emailSubject: String,
    val emailDate: String,
    val emailBody: String,
    val hasAttachment: Boolean
)

@Composable
fun EmailItemComponent(
    emailItem: EmailItem
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = TemporalyTheme.dimens.paddingNormal,
                end = TemporalyTheme.dimens.paddingNormal,
                top = 5.dp,
                bottom = 5.dp,
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        shape = RoundedCornerShape(TemporalyTheme.dimens.roundedShapeNormal)
    ) {
        Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = TemporalyTheme.dimens.paddingMedium,
                vertical = TemporalyTheme.dimens.paddingMedium,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
//            imageVector = Icons.Default.Circle,
            contentDescription = "Email Status",
            painter = painterResource(id = R.drawable.ic_menu_dot),
            tint = if (emailItem.emailStatus) Color.Green else Color.Gray, // Replace with your actual color
            modifier = Modifier
                .padding(top = 3.dp)
                .align(Alignment.Top)
                .size(16.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = emailItem.emailSubject,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = TemporalyTheme.dimens.paddingMedium)
                )
                Text(
                    text = emailItem.emailDate,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surface,
                )
            }
            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(36.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = emailItem.emailBody,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = TemporalyTheme.dimens.paddingMedium)
                )
                if (emailItem.hasAttachment) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu_attech),
                        contentDescription = "Attachment",
                        modifier = Modifier
                            .size(TemporalyTheme.dimens.iconSizeMinimum)
                            .rotate(25f)
                    )
                }
            }
        }
    }
    }
}

@Preview
@Composable
fun EmailItemPreview() {
    TemporalyTheme {
        EmailItemComponent(
            emailItem = EmailItem(
                emailStatus = true,
                emailSubject = "Asunto",
                emailDate = "27 Sep 2024 | 9:30:45 PM",
                emailBody = "Hola",
                hasAttachment = true
            )
        )
    }
}

