@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

import android.media.MediaPlayer

actual class Sound actual constructor(url: String) {
    private val player: MediaPlayer = MediaPlayer()

    init {
        player.setDataSource(url)
        player.prepareAsync()
    }

    actual fun play() {
        player.setOnPreparedListener { it.start() }
    }

    actual fun destroy() {
        player.release()
    }
}