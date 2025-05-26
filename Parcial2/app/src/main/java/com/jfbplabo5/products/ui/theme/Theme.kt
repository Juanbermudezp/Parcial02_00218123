package com.jfbplabo5.products.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect // Importar SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb // Importar toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView // Importar LocalView
import androidx.core.view.WindowCompat // Importar WindowCompat

// Colores para el tema oscuro
private val DarkColorScheme = darkColorScheme(
    primary = LightBlue, // Usar un color claro para el primary en tema oscuro
    onPrimary = DarkBlue,
    primaryContainer = DarkBlue,
    onPrimaryContainer = LightBlue,

    secondary = LightGreen,
    onSecondary = DarkGreen,
    secondaryContainer = DarkGreen,
    onSecondaryContainer = LightGreen,

    background = DarkGrey,
    onBackground = White,

    surface = DarkGrey,
    onSurface = White,

    surfaceVariant = Black,
    onSurfaceVariant = LightGrey,

    error = Color(0xFFCF6679), // Puedes mantener estos o definir tus propios colores de error
    onError = Color(0xFF000000),
    errorContainer = Color(0xFFB00020),
    onErrorContainer = Color(0xFFFFFFFF)
)

// Colores para el tema claro
private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = White,
    primaryContainer = LightBlue,
    onPrimaryContainer = DarkBlue,

    secondary = AccentGreen,
    onSecondary = White,
    secondaryContainer = LightGreen,
    onSecondaryContainer = DarkGreen,

    background = LightGrey,
    onBackground = Black,

    surface = White,
    onSurface = Black,

    surfaceVariant = Grey,
    onSurfaceVariant = DarkGrey,

    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFDD8DF),
    onErrorContainer = Color(0xFF410E0B)
)

@Composable
fun ProductsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Establece el color de la barra de estado al color primario del tema
            window.statusBarColor = colorScheme.primary.toArgb()
            // Controla el color de los iconos de la barra de estado (claro u oscuro)
            // Esto asegura que los iconos sean visibles sobre el color de la barra de estado
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}