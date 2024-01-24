package ui.pokemonDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import data.model.Pokemon

@Composable
fun NameSection(pokemon: Pokemon) {
    val borderRadius = remember {
        RoundedCornerShape(
            topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp, bottomEnd = 36.dp
        )
    }

    Row(
        Modifier.fillMaxWidth().wrapContentHeight().border(
            width = 4.dp, color = Color.Black, shape = borderRadius
        ).background(
            Color.White, shape = borderRadius
        ).padding(12.dp).padding(end = 24.dp)
    ) {
        AsyncImage(
            model = pokemon.sprite,
            contentDescription = pokemon.name,
            modifier = Modifier.size(96.dp).background(
                secondaryBgColor, shape = RoundedCornerShape(
                    topStart = 8.dp, bottomStart = 8.dp, bottomEnd = 8.dp
                )
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth().background(
                secondaryBgColor, shape = RoundedCornerShape(
                    topEnd = 8.dp, bottomEnd = 8.dp
                )
            ).padding(8.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(pokemon.stringId, fontSize = 24.sp)
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    pokemon.name.uppercase(), fontSize = 24.sp
                )
                Text(
                    pokemon.genus.uppercase(), fontSize = 24.sp
                )
            }
        }
    }
}
