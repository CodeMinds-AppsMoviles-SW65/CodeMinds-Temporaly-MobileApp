package com.codeminds.temporaly.feature_about_us.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.codeminds.temporaly.R
import com.codeminds.temporaly.feature_about_us.presentation.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsScreen(modifier: Modifier = Modifier) {
    val workSansFontFamily = FontFamily(
        Font(R.font.worksans_medium, FontWeight.Medium),
        Font(R.font.worksans_semibold, FontWeight.SemiBold)
    )

    var showDialog by remember { mutableStateOf(false) }
    var showDialogPrivacyPolice by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AboutUsHeader(fontFamily = workSansFontFamily)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Sección About Us
            AboutUsSection(fontFamily = workSansFontFamily)

            // Sección Team Profile
            TeamProfileSection(fontFamily = workSansFontFamily)

            // Sección Terms and Conditions
            TermsAndConditionSection(
                fontFamily = workSansFontFamily,
                onClick = { showDialog = true }
            )
            if(showDialog) {
                TermsAndConditionsDialog(
                    showDialog = showDialog,
                    onDismiss = { showDialog = false },
                    fontFamily = workSansFontFamily
                )
            }

            // Sección Privacy Policy
            PrivacyPolicySection(
                fontFamily = workSansFontFamily ,
                onClick = { showDialogPrivacyPolice = true }
            )
            if(showDialogPrivacyPolice) {
                PrivacyPolicyDialog(
                    showDialog = showDialogPrivacyPolice,
                    onDismiss = { showDialogPrivacyPolice = false },
                    fontFamily = workSansFontFamily
                )
            }
            ConsentSection(
                fontFamily = workSansFontFamily,
                onContactClick = { /* Navegar a la página de contacto o mostrar información de contacto */ }
            )


        }
    }
}
