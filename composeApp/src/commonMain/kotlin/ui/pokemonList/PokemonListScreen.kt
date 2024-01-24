package ui.pokemonList

import SafeAreaInsets
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel

class PokemonListScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = getScreenModel<PokemonListViewModel>()
        val state by viewModel.state.collectAsState(initial = PokemonListState.Loading)

        val tileSize = with(LocalDensity.current) {
            10.dp.toPx()
        }

        val backgroundBrush = remember {
            Brush.verticalGradient(
                0.0f to Color(0xFF50735B),
                0.5f to Color(0xFF50735B),
                0.5f to Color(0xFF496244),
                1.0f to Color(0xFF496244),
                endY = tileSize,
                tileMode = TileMode.Repeated
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize().background(backgroundBrush)
                .padding(top = SafeAreaInsets.Top.dp)
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

