package com.tematihonov.testpizza.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tematihonov.testpizza.domain.models.responseProducts.Product
import com.tematihonov.testpizza.ui.colors
import com.tematihonov.testpizza.ui.theme.Typography

@Composable
fun MenuItem(product: Product, onClickProduct: () -> Unit) {
    Column {
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colors.greyDivider
        )
        Box(
            Modifier
                .background(MaterialTheme.colors.backgroundMain)
                .fillMaxWidth()
                .padding(16.dp)
                .clickable(onClick = onClickProduct)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                AsyncImage(
                    model = product.img,
                    contentDescription = null,
                    modifier = Modifier.size(135.dp).padding(end = 22.dp)
                )
                Column(Modifier.height(135.dp), verticalArrangement = Arrangement.SpaceBetween) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(product.name, style = Typography.titleLarge)
                        Text(
                            text = product.description,
                            style = Typography.bodyLarge,
                            maxLines = 4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
                        Card(
                            modifier = Modifier,
                            shape = RoundedCornerShape(6.dp),
                            border = BorderStroke(1.dp, MaterialTheme.colors.pinkBottomBar),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.backgroundMain)
                        ) {
                            Text(
                                text = "от ${product.price} р.",
                                style = Typography.labelLarge,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 18.dp),
                                color = MaterialTheme.colors.pinkBottomBar
                            )
                        }
                    }
                }
            }
        }
    }
}


