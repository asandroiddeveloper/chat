package com.asandroiddeveloper.chat.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.asandroiddeveloper.chat.ui.theme.ChatTheme

private data class StackEntry(val label: String, val value: String)

private val toolchain = listOf(
    StackEntry("Kotlin", "2.4.20"),
    StackEntry("Compose BOM", "2026.09.00"),
    StackEntry("Android Gradle Plugin", "9.3.3"),
    StackEntry("Gradle", "9.6.0"),
    StackEntry("minSdk / targetSdk", "24 / 37"),
)

/**
 * Placeholder home screen for the scaffold milestone.
 *
 * It exists to prove the toolchain works end to end (theme, typography, Compose
 * previews, icon, edge-to-edge). The real chat screens replace it next.
 */
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            AppLogo(size = 96.dp)

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Chat",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Android scaffold is ready — Kotlin, Jetpack Compose and Material 3.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.height(28.dp))

            ToolchainCard()

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Next up: conversations, message bubbles and the composer.",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun ToolchainCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "TOOLCHAIN",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )

            Spacer(Modifier.height(12.dp))

            toolchain.forEachIndexed { index, entry ->
                if (index > 0) {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 10.dp),
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = entry.label,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Text(
                        text = entry.value,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}

@Composable
private fun AppLogo(size: Dp, modifier: Modifier = Modifier) {
    val primary = MaterialTheme.colorScheme.primary
    val secondary = MaterialTheme.colorScheme.secondary

    Canvas(modifier = modifier.size(size)) {
        val side = this.size.minDimension

        // Rounded square with the brand gradient
        val corner = side * 0.26f
        drawRoundRect(
            brush = Brush.linearGradient(
                colors = listOf(primary, secondary),
                start = Offset.Zero,
                end = Offset(side, side),
            ),
            size = Size(side, side),
            cornerRadius = CornerRadius(corner, corner),
        )

        // Speech bubble
        val bubbleWidth = side * 0.58f
        val bubbleHeight = side * 0.42f
        val bubbleLeft = (side - bubbleWidth) / 2f
        val bubbleTop = side * 0.28f
        val bubbleCorner = bubbleHeight * 0.34f

        drawRoundRect(
            color = Color.White,
            topLeft = Offset(bubbleLeft, bubbleTop),
            size = Size(bubbleWidth, bubbleHeight),
            cornerRadius = CornerRadius(bubbleCorner, bubbleCorner),
        )

        // Bubble tail
        val tail = Path().apply {
            moveTo(bubbleLeft + bubbleWidth * 0.24f, bubbleTop + bubbleHeight - 1f)
            lineTo(bubbleLeft + bubbleWidth * 0.24f, bubbleTop + bubbleHeight + side * 0.11f)
            lineTo(bubbleLeft + bubbleWidth * 0.54f, bubbleTop + bubbleHeight - 1f)
            close()
        }
        drawPath(path = tail, color = Color.White)

        // Typing dots
        val dotRadius = bubbleHeight * 0.085f
        val dotCenterY = bubbleTop + bubbleHeight / 2f
        listOf(0.32f, 0.5f, 0.68f).forEach { fraction ->
            drawCircle(
                color = primary,
                radius = dotRadius,
                center = Offset(bubbleLeft + bubbleWidth * fraction, dotCenterY),
            )
        }
    }
}

@Preview(name = "Home — light", showBackground = true)
@Composable
private fun HomeScreenLightPreview() {
    ChatTheme(darkTheme = false) { HomeScreen() }
}

@Preview(name = "Home — dark", showBackground = true)
@Composable
private fun HomeScreenDarkPreview() {
    ChatTheme(darkTheme = true) { HomeScreen() }
}
