package com.tematihonov.testpizza.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.tematihonov.testpizza.R
import com.tematihonov.testpizza.navigation.BottomNavItem
import com.tematihonov.testpizza.navigation.TestPizzaNavigation
import com.tematihonov.testpizza.presentation.components.BottomNavigationBar
import com.tematihonov.testpizza.presentation.components.TopAppBarMenu
import com.tematihonov.testpizza.ui.colors
import com.tematihonov.testpizza.ui.theme.TestPizzaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestPizzaTheme {
                val bottomBarItems = listOf(
                    BottomNavItem(
                        name = stringResource(id = R.string.screen_menu),
                        route = "menu",
                        icon = R.drawable.icon_menu
                    ),
                    BottomNavItem(
                        name = stringResource(id = R.string.screen_profile),
                        route = "profile",
                        icon = R.drawable.icon_profile
                    ),
                    BottomNavItem(
                        name = stringResource(id = R.string.screen_basket),
                        route = "basket",
                        icon = R.drawable.icon_basket
                    ),
                )
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(
                            modifier = Modifier
                                .background(color = MaterialTheme.colors.backgroundBottomBar)
                                .height(56.dp),
                            items = bottomBarItems,
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            })
                    },
                    topBar = {
                        TopAppBarMenu()
                    },
                    containerColor = MaterialTheme.colors.backgroundMain
                ) { padding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)){
                        TestPizzaNavigation(navController = navController, )
                    }
                }
            }
        }
    }
}
