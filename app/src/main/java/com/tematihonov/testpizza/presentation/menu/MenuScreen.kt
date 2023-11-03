package com.tematihonov.testpizza.presentation.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematihonov.testpizza.presentation.components.MenuBanner
import com.tematihonov.testpizza.presentation.components.MenuCategories
import com.tematihonov.testpizza.presentation.components.TopAppBarMenu

@Composable
fun MenuScreen() {
    val viewModel = hiltViewModel<MenuViewModel>()

    Column(Modifier.fillMaxSize()) {
        TopAppBarMenu()
        MenuBanner()
        MenuCategories(viewModel = viewModel)

    }
}

