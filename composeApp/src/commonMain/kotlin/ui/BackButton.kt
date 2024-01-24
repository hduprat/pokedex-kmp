package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.pokemonDetails.backButtonBgColor

@Composable
fun BackButton() {
    val navigator = LocalNavigator.currentOrThrow

    Box(modifier = Modifier.clickable { navigator.pop() }
        .background(backButtonBgColor, RoundedCornerShape(8.dp))
        .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
        .padding(horizontal = 8.dp, vertical = 4.dp)) {
        Text(
            "Retour".uppercase(),
            fontSize = 20.sp,
            style = MaterialTheme.typography.body1.copy(
                shadow = Shadow(
                    Color(0x55000000), offset = Offset(1.0f, 1.0f)
                )
            )
        )
    }
}