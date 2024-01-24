package di.pokemonList

import data.ApiService
import data.PokemonRepository
import data.api
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ui.pokemonList.PokemonListViewModel

val pokemonListModule = module {
    single(createdAtStart = true) { api } bind ApiService::class
    singleOf(::PokemonRepository)
    factory { PokemonListViewModel(get()) }
}