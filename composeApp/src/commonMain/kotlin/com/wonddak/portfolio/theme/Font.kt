package com.wonddak.portfolio.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.vitro_core

@Composable
fun getFont() = FontFamily(
    Font(Res.font.vitro_core)
)
