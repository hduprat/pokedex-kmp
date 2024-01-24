package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GenusEntryDto(val genus: String, override val language: NamedAPIResource): ILocalizedResource
