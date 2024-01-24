package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(widthDp = 120, heightDp = 240)
@Composable
fun StripedBackgroundPreview() {
    val bgBrush = StripedBackground(
        colors = listOf(
            Color(0xFF50735B),
            Color(0xFF496244),
            Color(0xFF314A2F),
        ),
        height = 25.dp
    )

    Box(
        modifier = Modifier.fillMaxSize().background(
            brush = bgBrush
        )
    )
}