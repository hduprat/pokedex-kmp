package ui.pokemonList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import data.model.Pokemon
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun PokemonList(list: List<Pokemon>, onEndReached: suspend () -> Unit) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier.padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(list, key = { it.id }) {
            Box(Modifier.animateItemPlacement()) {
                PokemonItem(
                    it
                )
            }
        }
        item { Spacer(modifier = Modifier.height(WindowInsets.safeDrawing.getBottom(LocalDensity.current).dp)) }
    }

    LaunchedEffect(scrollState, list.size) {
        snapshotFlow { list.size - scrollState.firstVisibleItemIndex }.map { index ->
            index <= 20
        }.distinctUntilChanged().filter { it }.collect {
            onEndReached()
        }
    }


}