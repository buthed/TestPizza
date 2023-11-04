package com.tematihonov.testpizza.presentation.menu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomShadow() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(10.dp)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0x2BBEBEBE),
                    Color.Transparent,
                )
            )
        )
    )
}