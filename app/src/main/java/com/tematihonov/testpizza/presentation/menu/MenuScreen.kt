package com.tematihonov.testpizza.presentation.menu

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematihonov.testpizza.presentation.menu.components.BottomShadow
import com.tematihonov.testpizza.presentation.menu.components.MenuBanner
import com.tematihonov.testpizza.presentation.menu.components.MenuCategories
import com.tematihonov.testpizza.presentation.menu.components.MenuItem
import com.tematihonov.testpizza.ui.colors
import com.tematihonov.testpizza.utils.connectivity_observer.ConnectivityObserver
import com.tematihonov.testpizza.utils.connectivity_observer.NetworkConnectivityObserver
import kotlinx.coroutines.delay

@Composable
fun MenuScreen() {
    val viewModel = hiltViewModel<MenuViewModel>()
    val context = LocalContext.current
    val state = rememberLazyListState()

    val connectivityObserver = NetworkConnectivityObserver(context)
    val networkStatus by connectivityObserver.observe().collectAsState(
        initial = ConnectivityObserver.Status.Unavailable
    )
    viewModel.currentNetworkStatus = networkStatus.name

    Column(Modifier.fillMaxSize()) {
        AnimatedVisibility(visible = state.firstVisibleItemIndex == 0) {
            MenuBanner()
        }
        MenuCategories(viewModel = viewModel)
        AnimatedVisibility(visible = state.firstVisibleItemIndex != 0) {
            BottomShadow()
        }
        if (viewModel.isLoadingProducts) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(100.dp),
                    color = MaterialTheme.colors.pinkBottomBar)
            }
        } else {
            LazyColumn(state = state) {
                items(viewModel.productsList) {product ->
                    MenuItem(product) {  }
                }
            }
        }
    }
    LaunchedEffect(true) {
        delay(150)
        viewModel.loadProducts(networkStatus = networkStatus.name)
    }
}

