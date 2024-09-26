package com.codeminds.temporaly.feature_about_us.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.codeminds.temporaly.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsScreen(modifier: Modifier = Modifier) {
    val workSansFontFamily = FontFamily(
        Font(R.font.worksans_medium, FontWeight.Medium),
        Font(R.font.worksans_semibold, FontWeight.SemiBold)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Privacy Policy",
                        color = Color.White,
                        fontFamily = workSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 26.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Acción de retroceso aquí */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF2979FF)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Título de la pantalla
            Text(
                text = "MS CodeMinds",
                fontFamily = workSansFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Image(
                painter = rememberAsyncImagePainter("https://i.ibb.co/mvLhy4h/about-us.jpg"),
                contentDescription = "Welcome Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            // Sección About Us
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "About Us",
                style = TextStyle(
                    fontFamily = workSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "At CodeMinds, we are a passionate team of students from the Universidad Peruana de Ciencias Aplicadas (UPC), united by our dedication to technology and commitment to excellence in every project we undertake.",
                style = TextStyle(
                    fontFamily = workSansFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )
            )

            // Sección Team Profile
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Team Profile",
                style = TextStyle(
                    fontFamily = workSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = rememberAsyncImagePainter("https://i.ibb.co/1mJr2p3/mateo.jpg"),
                    contentDescription = "Team Member 1",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                Image(
                    painter = rememberAsyncImagePainter("https://i.ibb.co/vD9kZkr/abel.jpg"),
                    contentDescription = "Team Member 2",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                Image(
                    painter = rememberAsyncImagePainter("https://i.ibb.co/JWLpkZ0/belen.jpg"),
                    contentDescription = "Team Member 3",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                Image(
                    painter = rememberAsyncImagePainter("https://i.ibb.co/XxXKvWF/alex.jpg"),
                    contentDescription = "Team Member 4",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "The team is made up of students who are passionate about technology and software development: Mateo Vílchez, Alex Ávila, Belen Ramos, and Abel Ortega.",
                style = TextStyle(
                    fontFamily = workSansFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )
            )
            // Sección Terms and Conditions
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Terms and Conditions",
                style = TextStyle(
                    fontFamily = workSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "At CodeMinds, we are a passionate team of students from the Universidad Peruana de Ciencias Aplicadas (UPC), united by our dedication to technology and commitment to excellence in every project we undertake.",
                style = TextStyle(
                    fontFamily = workSansFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                    )
            )
            // Sección Privacy Policy
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Privacy Policy",
                style = TextStyle(
                    fontFamily = workSansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "At CodeMinds, we are a passionate team of students from the Universidad Peruana de Ciencias Aplicadas (UPC), united by our dedication to technology and commitment to excellence in every project we undertake.",
                style = TextStyle(
                    fontFamily = workSansFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )
            )
        }
    }
}
