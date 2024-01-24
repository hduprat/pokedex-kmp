package data.adapter

import data.dto.FlavorTextEntryDto
import data.dto.ILocalizedResource
import data.dto.PokemonDto
import data.dto.PokemonSpeciesDto
import data.model.Pokemon

private fun <T : ILocalizedResource> getFrenchVersionOf(list: List<T>): T? =
    list.find { it.language.name == "fr" }

private fun findBestDescription(entries: List<FlavorTextEntryDto>): String {
    if (entries.isEmpty()) return "Pas de description."
    val language = if ("fr" in entries.map { it.language.name }) "fr" else "en"
    val eligibleDescriptions = entries.filter { it.language.name == language }

    if (eligibleDescriptions.isEmpty()) return entries[0].flavor_text
    val bestDescription = eligibleDescriptions.find { it.version.name == "sapphire" }
    return (bestDescription ?: eligibleDescriptions[0]).flavor_text
}

class PokemonDtoAdapter {
    companion object {
        fun toPokemon(pokemon: PokemonDto, species: PokemonSpeciesDto): Pokemon = Pokemon(
            id = pokemon.id,
            name = getFrenchVersionOf(species.names)?.name ?: pokemon.name,
            enName = pokemon.name,
            sprite = pokemon.sprites.front_default,
            genus = getFrenchVersionOf(species.genera)?.genus ?: "Unknown",
            description = findBestDescription(species.flavor_text_entries)
        )

    }
}