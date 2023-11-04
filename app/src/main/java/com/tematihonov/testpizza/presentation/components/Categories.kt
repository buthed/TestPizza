package com.tematihonov.testpizza.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.testpizza.presentation.menu.MenuViewModel
import com.tematihonov.testpizza.ui.colors
import com.tematihonov.testpizza.ui.theme.Typography
import com.tematihonov.testpizza.utils.connectivity_observer.ConnectivityObserver
import com.tematihonov.testpizza.utils.connectivity_observer.NetworkConnectivityObserver

@Composable
fun MenuCategories(viewModel: MenuViewModel) {
    val context = LocalContext.current
    val connectivityObserver = NetworkConnectivityObserver(context)
    val networkStatus by connectivityObserver.observe().collectAsState(
        initial = ConnectivityObserver.Status.Unavailable
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 8.dp,
            )
    ) {
        items(viewModel.categories) {
            Box(modifier = Modifier.padding(start = 8.dp)) {
                if (viewModel.currentCategory == it) SelectedCategory(selectCategory = {
                    viewModel.setNewCategory(
                        it
                    )
                }, category = it)
                else Category(selectCategory = { viewModel.setNewCategory(it) }, category = it)
            }
        }
    }
}

@Composable
fun SelectedCategory(selectCategory: () -> Unit, category: String) {
    Box(
        modifier = Modifier
            .shadow(10.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(MaterialTheme.colors.lowPink)
            .padding(vertical = 8.dp, horizontal = 23.dp)
            .clickable(onClick = selectCategory),
        contentAlignment = Alignment.Center
    ) {
        Text(text = category, style = Typography.bodyMedium, color = MaterialTheme.colors.pinkBottomBar)
    }
}

@Composable
fun Category(selectCategory: () -> Unit, category: String) {
    Box(
        modifier = Modifier
            .shadow(10.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color.White)
            .padding(vertical = 8.dp, horizontal = 23.dp)
            .clickable(onClick = selectCategory),
        contentAlignment = Alignment.Center
    ) {
        Text(text = category, style = Typography.bodyMedium, color = MaterialTheme.colors.textGrayLow)
    }
}

@Preview
@Composable
fun SelectedCategoryPreview() {
    SelectedCategory(selectCategory = {}, category = "Label")
}

@Preview
@Composable
fun CategoryPreview() {
    Category(selectCategory = {}, category = "Label")
}