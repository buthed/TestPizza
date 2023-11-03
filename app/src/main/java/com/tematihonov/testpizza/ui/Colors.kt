package com.tematihonov.testpizza.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors(
    val backgroundMain: Color = Color(0xFFFBFBFB),
    val backgroundBottomBar: Color = Color(0xFFF0F0F0),
    val greyBottomBar: Color = Color(0xFF7B7B7B),
    val pinkBottomBar: Color = Color(0xFFFD3A69),
    val backgroundCard: Color = Color(0xFFF5F5F5),
    val textBlack: Color = Color(0xFF202830),
    val textGray: Color = Color(0xFFAAAAAD),
    val textGrayLow: Color = Color(0xFFC3C4C9),
    val mainPink: Color = Color(0xFFFD3A69),
    val lowPink: Color = Color(0xFFFFCDD5),
    val greyDivider: Color = Color(0xFFF3F5F9),

)

val LocalColors = compositionLocalOf { Colors() }

val MaterialTheme.colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current