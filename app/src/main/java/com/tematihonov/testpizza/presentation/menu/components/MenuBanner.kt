package com.tematihonov.testpizza.presentation.menu.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.tematihonov.testpizza.R
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MenuBanner() {

    val pagerState = rememberPagerState()
    val bannerAnimation by animateDpAsState(
        targetValue = if (pagerState.currentPage != 0) 0.dp else 8.dp,
        animationSpec = tween(200), label = ""
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            HorizontalPager(
                count = images.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(112.dp),
                contentPadding = PaddingValues(
                    start = if (pagerState.currentPage == 0) 0.dp else 32.dp,
                    end = 32.dp
                ),
                itemSpacing = 0.dp
            ) { currentPage ->
                Box(
                    Modifier
                        .padding(start = bannerAnimation)
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - currentPage) + pagerState.currentPageOffset)
                                .absoluteValue
                            alpha = lerp(
                                start = 0.2f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    Image(
                        painter = painterResource(id = images[currentPage]),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(112.dp)
                            .padding(
                                start = 8.dp,
                                end = 8.dp
                            )
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                }

            }
        }
    }
}

val images = listOf(
    R.drawable.banner_1,
    R.drawable.banner_2,
    R.drawable.banner_3,
)