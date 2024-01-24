package ui.pokemonList

sealed class PokemonListIntent {
    data object LoadMore: PokemonListIntent()
}