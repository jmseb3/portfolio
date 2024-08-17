package com.wonddak.portfolio.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.MangoDdobak_R
import portfolio.composeapp.generated.resources.Res

@Composable
fun getFont() = FontFamily(
    Font(Res.font.MangoDdobak_R)
)
