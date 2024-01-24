package ui.pokemonList

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.compose.SubcomposeAsyncImage
import data.model.Pokemon
import ui.pokemonDetails.PokemonDetailsScreen

val bgColor1 = Color(0xFF579EA6)
val bgColor2 = Color(0xFF8AAFA8)
val bgBrush = Brush.verticalGradient(
    0.0f to bgColor1,
    0.66f to bgColor1,
    0.66f to bgColor2,
    0.90f to bgColor2,
    0.90f to bgColor1,
    1.0f to bgColor1,
)

@Composable
fun PokemonItem(pokemon: Pokemon) {
    val formattedName = pokemon.name.uppercase()
    val navigator = LocalNavigator.currentOrThrow

    Row(
        Modifier.clickable { navigator.push(PokemonDetailsScreen(pokemon)) }.fillMaxWidth()
            .border(width = 2.dp, color = Color.DarkGray, shape = RoundedCornerShape(8.dp))
            .background(bgBrush, shape = RoundedCornerShape(8.dp)).padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        SubcomposeAsyncImage(model = pokemon.sprite,
            contentDescription = pokemon.name,
            modifier = Modifier.size(72.dp),
            loading = { CircularProgressIndicator() },
            error = { error ->
                Box(modifier = Modifier.background(Color.Red)) {
                    println(error.result.toString())
                }
            })
        Text(
            "${pokemon.stringId} - $formattedName",
            color = Color.White,
            style = MaterialTheme.typography.body1.copy(
                fontSize = 24.sp,
                shadow = Shadow(Color.Black, offset = Offset(2.0f, 2.0f), blurRadius = 0.0f)
            )
        )
    }
}