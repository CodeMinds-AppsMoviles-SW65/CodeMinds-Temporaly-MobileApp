package com.codeminds.temporaly.feature_about_us.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TermsAndConditionSection(fontFamily: FontFamily, onClick: () -> Unit) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Terms and Conditions",
        style = androidx.compose.ui.text.TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    )
    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = "These Legal Terms constitute a legally binding agreement made between you, whether personally or on behalf of an entity, and CodeMinds, concerning your access to and use of the Services. You agree that by accessing the Services, you have read, understood, and agreed to be bound by all of these Legal Terms. IF YOU DO NOT AGREE WITH ALL OF THESE LEGAL TERMS, THEN YOU ARE EXPRESSLY PROHIBITED FROM USING THE SERVICES AND YOU MUST DISCONTINUE USE IMMEDIATELY... click to read more",
        style = androidx.compose.ui.text.TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    )
}