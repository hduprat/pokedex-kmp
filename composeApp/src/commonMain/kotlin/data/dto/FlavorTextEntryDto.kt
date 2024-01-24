package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FlavorTextEntryDto(
    val flavor_text: String, val version: NamedAPIResource, override val language: NamedAPIResource
): ILocalizedResource
