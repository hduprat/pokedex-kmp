package data

import kotlinx.serialization.Serializable

@Serializable
data class SimplePokemon(val name: String, val url: String)
