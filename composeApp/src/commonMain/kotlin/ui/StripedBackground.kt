package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun StripedBackground(colors: List<Color>, height: Dp): Brush {
    val tileSize = with(LocalDensity.current) {
        height.toPx()
    }

    val gradientColors = remember(colors) {
        colors.foldIndexed(emptyArray<Pair<Float, Color>>()) { index, pairs, color ->
            pairs + (index.toFloat() / colors.size to color) + ((index + 1).toFloat() / colors.size to color)
        }
    }

    return remember {
        Brush.verticalGradient(
            *gradientColors, startY = 0.0f, endY = tileSize, tileMode = TileMode.Repeated
        )
    }
}
