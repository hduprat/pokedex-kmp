package ui.pokemonDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Pokemon

private val bgBrush = Brush.horizontalGradient(
    0.0f to Color(0xFFCE397A),
    0.15f to Color(0xFFCE397A),
    0.2f to Color(0xFFCB6798),
    0.75f to Color(0xFFCB6798),
    0.8f to Color.White,
    startX = 0.0f,
)

@Composable
fun DescriptionSection(pokemon: Pokemon) {
    Row(
        Modifier.fillMaxWidth().height(IntrinsicSize.Min).border(
            width = 2.dp, color = Color(0xFFCE397A), shape = RoundedCornerShape(12.dp)
        ).clip(RoundedCornerShape(12.dp)).background(Color.White),
    ) {
        Column(Modifier.width(30.dp).fillMaxHeight().background(bgBrush)) {}
        Column(Modifier.weight(1.0f).padding(vertical = 12.dp)) {
            Text(pokemon.description.replace('\n', ' '), fontSize = 24.sp)
        }
        Column(
            Modifier.scale(scaleX = -1.0f, scaleY = 1.0f).width(30.dp).fillMaxHeight()
                .background(bgBrush)
        ) {}
    }
}