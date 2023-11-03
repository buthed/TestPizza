package com.tematihonov.testpizza.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tematihonov.testpizza.R
import com.tematihonov.testpizza.ui.theme.Typography

@Composable
fun TopAppBarMenu() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Mосква", style = Typography.bodyMedium)
            Image(painter = painterResource(id = R.drawable.icon_arrow), contentDescription = "",
                Modifier.size(24.dp))
            //TODO add DropdownMenu?
        }
        Image(painter = painterResource(id = R.drawable.icon_qr), contentDescription = "",
            Modifier
                .size(24.dp)
                .padding(1.dp))
    }
}