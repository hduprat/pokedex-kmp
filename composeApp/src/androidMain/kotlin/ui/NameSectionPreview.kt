package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import data.model.Pokemon
import ui.pokemonDetails.NameSection

@Preview(widthDp = 600, heightDp = 800)
@Composable
fun NameSectionPreview() {
    NameSection(pokemon = Pokemon(
        id = 1,
        enName = "Bulbasaur",
        name = "Bulbizarre",
        genus = "Pokémon Graine",
        description = "Il a une graine sur le dos depuis sa naissance. En absorbant les rayons du soleil, sa graine grandit progressivement.",
        sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
    ))
}