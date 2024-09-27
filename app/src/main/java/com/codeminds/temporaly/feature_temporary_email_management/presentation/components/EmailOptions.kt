package com.codeminds.temporaly.feature_temporary_email_management.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeminds.temporaly.R
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme

@Composable
fun MainLayout(email: String, onEmailCopy: () -> Unit, onRefresh: () -> Unit, onEmailChange: () ->Unit, onDelete: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(top = TemporalyTheme.dimens.paddingSmall)
            .padding(bottom = TemporalyTheme.dimens.paddingMedium)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = TemporalyTheme.dimens.paddingNormal
                ),
        ){
            TextButton(
                modifier = Modifier
                    .height(TemporalyTheme.dimens.buttonHeightSmall)
                    .weight(1f),
                shape = RoundedCornerShape(TemporalyTheme.dimens.roundedShapeNormal),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1A61D5),
                ),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(), // Asegura que la fila ocupe todo el ancho del TextButton
                    verticalAlignment = Alignment.CenterVertically, // Centra verticalmente el contenido
                    horizontalArrangement = Arrangement.Start // Alinea el contenido a la izquierda
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu_contact),
                        contentDescription = "email",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
                    Text(
                        text = "fuczep@smallntm.lol",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
            TextButton(
                modifier = Modifier
                    .size(TemporalyTheme.dimens.buttonHeightSmall),
                shape = RoundedCornerShape(TemporalyTheme.dimens.roundedShapeNormal),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1A61D5),
                ),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_copy),
                    contentDescription = "copy",
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = TemporalyTheme.dimens.paddingNormal
                ),
        ){
            TextButton(
                modifier = Modifier
                    .height(TemporalyTheme.dimens.buttonHeightSmall)
                    .weight(1f),
                shape = RoundedCornerShape(TemporalyTheme.dimens.roundedShapeNormal),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1A61D5),
                ),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 0.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
                onClick = { /*TODO*/ }
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier
                            .size(TemporalyTheme.dimens.iconSizeMinimum),
                        painter = painterResource(id = R.drawable.ic_menu_change),
                        contentDescription = "Refresh",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
                    Text(
                        text = "Refresh",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
            TextButton(
                modifier = Modifier
                    .height(TemporalyTheme.dimens.buttonHeightSmall)
                    .weight(1f),
                shape = RoundedCornerShape(TemporalyTheme.dimens.roundedShapeNormal),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1A61D5),
                ),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
                onClick = { /*TODO*/ }
            ) {

                Icon(
                    modifier = Modifier
                        .size(TemporalyTheme.dimens.iconSizeSmall),
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "New",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
                Text(
                    text = "New",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
            TextButton(
                modifier = Modifier
                    .height(TemporalyTheme.dimens.buttonHeightSmall)
                    .weight(1f),
                shape = RoundedCornerShape(TemporalyTheme.dimens.roundedShapeNormal),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1A61D5),
                ),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
                onClick = { /*TODO*/ }
            ) {

                Icon(
                    modifier = Modifier
                        .size(TemporalyTheme.dimens.iconSizeMinimum),
                    painter = painterResource(id = R.drawable.ic_menu_delete),
                    contentDescription = "Delete",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
                Text(
                    text = "Delete",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun EmailPreview() {
    TemporalyTheme {
        MainLayout("aberu@gmail.com", onEmailCopy = {}, onRefresh = {}, onEmailChange = {}, onDelete = {})
    }
}
