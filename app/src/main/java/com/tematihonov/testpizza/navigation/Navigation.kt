package com.tematihonov.testpizza.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tematihonov.testpizza.presentation.basket.BasketScreen
import com.tematihonov.testpizza.presentation.menu.MenuScreen
import com.tematihonov.testpizza.presentation.profile.ProfileScreen

@Composable
fun TestPizzaNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {
        composable("menu") { MenuScreen() }
        composable("profile") { ProfileScreen() }
        composable("basket") { BasketScreen() }
    }
}