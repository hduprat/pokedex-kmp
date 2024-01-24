import androidx.compose.runtime.Composable

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class SafeAreaInsets {
    companion object {
        @get:Composable
        val Top: Int
        @get:Composable
        val Bottom: Int
    }
}