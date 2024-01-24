package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesDto(
    val id: Int,
    val name: String,
    val names: List<LocalizedNameDto>,
    val flavor_text_entries: List<FlavorTextEntryDto>,
    val genera: List<GenusEntryDto>
)
