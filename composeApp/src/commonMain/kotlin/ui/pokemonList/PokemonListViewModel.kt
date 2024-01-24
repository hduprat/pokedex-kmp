@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

package ui.pokemonList

import cafe.adriel.voyager.core.model.ScreenModel
import data.PokemonRepository
import kotlinx.coroutines.flow.map
import org.mobilenativefoundation.store.store5.StoreReadResponse

class PokemonListViewModel(private val repository: PokemonRepository) : ScreenModel {
    private var size = 0
    val state = repository.list.map {
        when (it) {
            is StoreReadResponse.Loading -> PokemonListState.Loading
            is StoreReadResponse.Error -> PokemonListState.Error
            is StoreReadResponse.Data -> {
                size = it.value.size
                PokemonListState.ShowList(it.value)
            }

            else -> PokemonListState.ShowList(it.requireData())
        }
    }

    suspend fun handleIntent(intent: PokemonListIntent) {
        when (intent) {
            is PokemonListIntent.LoadMore -> {
                repository.loadSubList(
                    size, 5
                )
            }
        }
    }
}