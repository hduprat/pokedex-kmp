@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

expect class Sound(url: String) {
    fun play()
    fun destroy()
}