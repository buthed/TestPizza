package com.tematihonov.testpizza.presentation.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematihonov.testpizza.presentation.components.MenuBanner
import com.tematihonov.testpizza.presentation.components.MenuCategories
import com.tematihonov.testpizza.presentation.components.MenuItem
import com.tematihonov.testpizza.presentation.components.TopAppBarMenu

@Composable
fun MenuScreen() {
    val viewModel = hiltViewModel<MenuViewModel>()

    Column(Modifier.fillMaxSize()) {
        TopAppBarMenu()
        MenuBanner()
        MenuCategories(viewModel = viewModel)
        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(viewModel.productsList) {product ->
                MenuItem(product)
            }
        }
    }
}

