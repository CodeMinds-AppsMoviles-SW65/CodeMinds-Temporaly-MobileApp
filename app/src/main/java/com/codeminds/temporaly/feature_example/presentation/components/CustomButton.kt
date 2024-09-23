package com.codeminds.temporaly.feature_example.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    buttonColor: Color,
    onTap: () -> Unit = {}
) {
    Button(
        modifier = modifier
            .height(TemporalyTheme.dimens.buttonHeightNormal),
        shape = RoundedCornerShape(TemporalyTheme.dimens.roundedShapeNormal),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        onClick = {onTap()},

    ) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically),
            style = MaterialTheme.typography.bodyLarge,
            color= textColor
        )
    }
}

@Preview(
    name = "CustomButtonPreview",
    showBackground = true,
)
@Composable
fun CustomButtonPreview(){
    TemporalyTheme {
        CustomButton(
            text = "Hola",
            textColor = Color.White,
            buttonColor = Color.Black
        )
    }
}
