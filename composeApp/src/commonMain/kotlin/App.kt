import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import cafe.adriel.voyager.navigator.Navigator
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.fetch.NetworkFetcher
import data.httpClient
import ui.pokemonList.PokemonListScreen


@OptIn(ExperimentalCoilApi::class)
@Composable
fun App() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context).components {
            add(NetworkFetcher.Factory(httpClient = lazy { httpClient }))
        }.build()
    }

    MaterialTheme(
        typography = Typography(
            defaultFontFamily = FontFamily(
                font("PokemonRS", "pokemon_rs", FontWeight.Normal, FontStyle.Normal)
            )
        )
    ) {
        Navigator(PokemonListScreen())
    }
}
