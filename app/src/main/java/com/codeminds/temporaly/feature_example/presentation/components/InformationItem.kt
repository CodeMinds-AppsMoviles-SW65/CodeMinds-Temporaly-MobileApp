package com.codeminds.temporaly.feature_example.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme

@Composable
fun InformationItem(
    modifier: Modifier = Modifier,
    text: String,
    label: String
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge,
            color= MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge,
            color= MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(
    name = "InformationItemPreview",
    showBackground = true,
)
@Composable
fun InformationItemPreview(){
    TemporalyTheme {
        InformationItem(
            text = "Hola",
            label = "Abel"
        )
    }
}
