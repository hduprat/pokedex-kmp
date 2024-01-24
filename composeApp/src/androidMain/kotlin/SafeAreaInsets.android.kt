@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity

actual class SafeAreaInsets {
    actual companion object {
        actual val Top: Int
            // return value in dp
            @Composable get() = (WindowInsets.Companion.safeDrawing.getTop(LocalDensity.current) / LocalDensity.current.density).toInt()
        actual val Bottom: Int
            // return value in dp
            @Composable get() = (WindowInsets.Companion.safeDrawing.getBottom(LocalDensity.current) / LocalDensity.current.density).toInt()

    }
}