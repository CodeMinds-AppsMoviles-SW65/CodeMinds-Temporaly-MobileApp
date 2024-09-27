package com.codeminds.temporaly.feature_temporary_email_management.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeminds.temporaly.R
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme
import com.codeminds.temporaly.feature_temporary_email_management.presentation.components.EmailItem
import com.codeminds.temporaly.feature_temporary_email_management.presentation.components.EmailItemComponent
import com.codeminds.temporaly.feature_temporary_email_management.presentation.components.MainLayout

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenView() {

    val emails = listOf(
        EmailItem(
            emailStatus = true,
            emailSubject = "Asunto",
            emailDate = "27 Sep 2024 | 9:30:45 PM",
            emailBody = "Ya hiciste tu tarea?",
            hasAttachment = true
        ),
        EmailItem(
            emailStatus = true,
            emailSubject = "Saludo",
            emailDate = "27 Sep 2024 | 9:30:45 PM",
            emailBody = "Hola, como estas?",
            hasAttachment = true
        ),
        EmailItem(
            emailStatus = true,
            emailSubject = "Asunto",
            emailDate = "27 Sep 2024 | 9:30:45 PM",
            emailBody = "Hola",
            hasAttachment = true
        ),
    )


    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = R.drawable.ic_menu_contact,
            unselectedIcon = R.drawable.ic_menu_contact,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "History",
            selectedIcon = R.drawable.ic_menu_history,
            unselectedIcon = R.drawable.ic_menu_history,
            hasNews = false,
            badgeCount = 45
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.background,
                ),
                title = {
                    Text(
                        text = "Temporaly",
//                        modifier = Modifier.fillMaxWidth(),
                        modifier = Modifier
                            .padding(TemporalyTheme.dimens.paddingNormal),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.background
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_action_action),
                            contentDescription = "Menu",
                            tint = MaterialTheme.colorScheme.background,
                            modifier = Modifier.size(TemporalyTheme.dimens.iconSizeSmall)
                        )
                    }
                }
            )
        },
        bottomBar = {
            Column {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .shadow(4.dp, shape = RectangleShape)
                        .background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.2f))
                )
                NavigationBar(
//                    modifier = Modifier
//                        .height(56.dp),
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.secondary,
                    tonalElevation = 0.dp
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                            },
                            label = {
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.Top),
                                    text = item.title,
                                    style = MaterialTheme.typography.titleSmall,
                                    color = if (selectedItemIndex == index) {
                                        MaterialTheme.colorScheme.surface
                                    } else {
                                        MaterialTheme.colorScheme.secondary
                                    },
                                )
                            },
                            alwaysShowLabel = true,
                            icon = {
                                Icon(
                                    painter = if (selectedItemIndex == index) {
                                        painterResource(id = item.selectedIcon)
                                    } else {
                                        painterResource(id = item.unselectedIcon)
                                    },
                                    modifier = Modifier
                                        .size(TemporalyTheme.dimens.iconSizeSmall),
                                    contentDescription = item.title,
                                    tint = if (selectedItemIndex == index) {
                                        MaterialTheme.colorScheme.surface
                                    } else {
                                        MaterialTheme.colorScheme.secondary
                                    }
                                )
                            },
                            colors = NavigationBarItemColors(
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.background,
                            )
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            MainLayout(
                email = "abelortega@gmail.com",
                onEmailCopy = { /*TODO*/ },
                onRefresh = { /*TODO*/ },
                onEmailChange = { /*TODO*/ }) {
                
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
//                    .padding(top = 18.dp)
            ) {
                items(emails) { email ->
                    EmailItemComponent( email)
//                    Spacer(modifier = Modifier.height(2.dp))
                }
            }

        }
    }
}

@Preview(
    name = "HomeScreenPreview",
)
@Composable
fun HomeScreenPreview() {
    TemporalyTheme {
        HomeScreenView()
    }
}
