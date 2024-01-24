@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

import androidx.compose.runtime.Composable
import kotlinx.cinterop.useContents
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow

actual class SafeAreaInsets {
    actual companion object {
        actual val Top: Int
            @Composable get() = (UIApplication.sharedApplication.windows).filterIsInstance<UIWindow>()
                .firstOrNull {
                    it.isKeyWindow()
                }?.safeAreaInsets()?.useContents { this.top.toInt() } ?: 0
        actual val Bottom: Int
            @Composable get() = (UIApplication.sharedApplication.windows).filterIsInstance<UIWindow>()
                .firstOrNull { it.isKeyWindow() }?.safeAreaInsets()
                ?.useContents { this.bottom.toInt() } ?: 0
    }
}