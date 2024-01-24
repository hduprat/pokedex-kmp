package data.dto

import data.SimplePokemon
import kotlinx.serialization.Serializable

@Serializable
data class PokemonPageDto(val results: List<SimplePokemon>)
