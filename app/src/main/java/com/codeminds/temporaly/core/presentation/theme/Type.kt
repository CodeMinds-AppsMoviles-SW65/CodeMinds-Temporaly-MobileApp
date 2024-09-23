package com.codeminds.temporaly.core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.codeminds.temporaly.R

// Set of Material typography styles to start with

val PoppinsFont = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.SemiBold),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_light, FontWeight.Light),
)

val ProductSansFont = FontFamily(
    Font(R.font.product_sans_bold, FontWeight.Bold),
    Font(R.font.product_sans_regular, FontWeight.Normal),
)

val UrbanistFont = FontFamily(
    Font(R.font.urbanist_bold, FontWeight.Bold),
    Font(R.font.urbanist_semibold, FontWeight.SemiBold),
    Font(R.font.urbanist_medium, FontWeight.Medium),
    Font(R.font.urbanist_regular, FontWeight.Normal),
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 88.sp,
        lineHeight = 0.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    bodyMedium = TextStyle(
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    headlineLarge = TextStyle(
        fontFamily = ProductSansFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    headlineMedium = TextStyle(
        fontFamily = ProductSansFont,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    headlineSmall = TextStyle(
        fontFamily = ProductSansFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    titleLarge = TextStyle(
        fontFamily = ProductSansFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    titleMedium = TextStyle(
        fontFamily = UrbanistFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    titleSmall = TextStyle(
        fontFamily = UrbanistFont,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    labelLarge = TextStyle(
        fontFamily = ProductSansFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    labelMedium = TextStyle(
        fontFamily = ProductSansFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    ),
    labelSmall = TextStyle(
        fontFamily = ProductSansFont,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    )
)