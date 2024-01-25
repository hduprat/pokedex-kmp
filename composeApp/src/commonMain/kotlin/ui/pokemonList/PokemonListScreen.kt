package ui.pokemonList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import ui.StripedBackground

class PokemonListScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = getScreenModel<PokemonListViewModel>()
        val state by viewModel.state.collectAsState(initial = PokemonListState.Loading)

        val backgroundBrush = StripedBackground(listOf(Color(0xFF50735B), Color(0xFF496244)), 10.dp)

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize().background(backgroundBrush).windowInsetsPadding(
                WindowInsets(
                    top = WindowInsets.Companion.safeDrawing.getTop(
                        LocalDensity.current
                    )
                )
            )
        ) {
            Text(
                "Pokédex",
                style = MaterialTheme.typography.h3.copy(
                    shadow = Shadow(
                        Color.Black, offset = Offset(8.0f, 8.0f), blurRadius = 0.0f
                    )
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
            when (val s = state) {
                is PokemonListState.Loading -> Text("Chargement...")
                is PokemonListState.Error -> Text("Oh non, il y a eu une erreur.")
                is PokemonListState.ShowList -> PokemonList(list = s.data, onEndReached = {
                    viewModel.handleIntent(
                        PokemonListIntent.LoadMore
                    )
                })
            }
        }
    }

}

