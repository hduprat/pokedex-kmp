package ui.pokemonDetails

import Sound
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import data.model.Pokemon
import ui.BackButton

val bgColor = Color(0xFF413B6D)
val bgColorAlt = Color(0xFF5D5B9F)

val secondaryBgColor = Color(0xFFDCDCDC)
val backButtonBgColor = Color(0xFFD44A3E)

data class PokemonDetailsScreen(val pokemon: Pokemon) : Screen {
    private val cry = Sound("https://play.pokemonshowdown.com/audio/cries/${pokemon.enName}.mp3")

    @Composable
    override fun Content() {
        val tileSize = with(LocalDensity.current) {
            10.dp.toPx()
        }

        val backgroundBrush = remember {
            Brush.verticalGradient(
                0.0f to bgColor,
                0.5f to bgColor,
                0.5f to bgColorAlt,
                1.0f to bgColorAlt,
                endY = tileSize,
                tileMode = TileMode.Repeated
            )
        }

        DisposableEffect(cry) {
            cry.play()
            onDispose { cry.destroy() }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize().background(backgroundBrush)
                .windowInsetsPadding(WindowInsets.safeDrawing).padding(top = 12.dp)
                .padding(horizontal = 4.dp)
        ) {
            BackButton()
            NameSection(pokemon)
            DescriptionSection(pokemon)
        }
    }
}