package ui.pokemonList

import data.model.Pokemon

sealed class PokemonListState {
    data object Loading: PokemonListState()
    data object Error: PokemonListState()
    data class ShowList(val data: List<Pokemon>): PokemonListState()
}