@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

import platform.AVFAudio.AVAudioPlayerDelegateProtocol
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.play
import platform.Foundation.NSURL
import platform.darwin.NSObject

actual class Sound actual constructor(url: String) : NSObject(), AVAudioPlayerDelegateProtocol {
    private var player: AVPlayer? = null

    init {
        val nsUrl = NSURL.URLWithString(url) ?: throw Exception("Bad URL")
        player = AVPlayer(uRL = nsUrl)
    }

    actual fun play() {
        player?.play()
    }

    actual fun destroy() {
        player = null
    }
}