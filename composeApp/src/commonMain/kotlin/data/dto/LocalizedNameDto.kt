package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LocalizedNameDto(val name: String, override val language: NamedAPIResource) :
    ILocalizedResource
