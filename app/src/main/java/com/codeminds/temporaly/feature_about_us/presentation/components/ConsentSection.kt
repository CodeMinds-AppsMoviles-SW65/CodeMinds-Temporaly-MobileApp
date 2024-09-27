package com.codeminds.temporaly.feature_about_us.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConsentSection(
    fontFamily: FontFamily,
    onContactClick: () -> Unit
) {
    var consentAccepted by remember { mutableStateOf(false) }

    Spacer(modifier = Modifier.height(16.dp))

    // Section Title
    Text(
        text = "Consent to Data Processing",
        style = androidx.compose.ui.text.TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    )
    Spacer(modifier = Modifier.height(8.dp))

    // Consent Details (Updated when consent is accepted)
    Text(
        text = if (consentAccepted) {
            "Thank you for accepting our data processing terms. By agreeing, you consent to our Privacy Policy and terms of service."
        } else {
            """
            1. Agreement: By using the Temporaly app, you agree to our Privacy Policy and the way we process your data as outlined. This includes the collection, storage, and use of personal information necessary for providing the app's services.
            
            2. Opt-in for Notifications: Users can opt in to receive notifications about app updates, features, and relevant information. You have the choice to enable or disable these notifications within your app settings.
            
            3. Revoking Consent: If you change your mind at any time, you have the right to withdraw your consent. You can do so by contacting us or changing your settings within the app.
            
            4. Contact Information: For any questions or concerns regarding your data, please contact us.
            """.trimIndent()
        },
        style = androidx.compose.ui.text.TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )


    Spacer(modifier = Modifier.height(16.dp))

    // Accept Button
    Button(
        onClick = { consentAccepted = true },
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Text(
            text = if (consentAccepted) "Enjoy the App :) !" else "I Agree",
            fontFamily = fontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
