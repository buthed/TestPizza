package com.tematihonov.testpizza.presentation.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tematihonov.testpizza.presentation.components.MenuBanner
import com.tematihonov.testpizza.presentation.components.TopAppBarMenu

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MenuScreen() {
    Column(Modifier.fillMaxSize()) {
        TopAppBarMenu()
        MenuBanner()

    }
}