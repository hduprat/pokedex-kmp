package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    val id: Int,
    val name: String,
    val sprites: SpritesDto,
    val types: List<NamedTypeDto>,
)
