package com.codeminds.temporaly.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme
import com.codeminds.temporaly.feature_example.presentation.home.HomeScreen
import com.codeminds.temporaly.feature_temporary_email_management.presentation.components.MainLayout
import com.codeminds.temporaly.feature_temporary_email_management.presentation.home.HomeScreenView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowsSize = calculateWindowSizeClass(this)
            TemporalyTheme(windowsSize = windowsSize.widthSizeClass) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Reemplazar por cualquier vista
//                    HomeScreen()
                    HomeScreenView()
//                    MainLayout("aberu@gmail.com", onEmailCopy = {}, onRefresh = {}, onEmailChange = {}, onDelete = {})
                }
            }
        }
    }
}