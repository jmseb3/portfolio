package com.wonddak.portfolio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.wonddak.portfolio.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun App() = AppTheme {
    val configuration = LocalWindowInfo.current.containerSize

    val mode = when {
        configuration.width >= 1200 -> {
            Mode.Desktop
        }

        else -> {
            Mode.Mobile
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (mode == Mode.Mobile){
            AboutMe(Modifier.fillMaxWidth(), mode)
            AboutProject(Modifier.fillMaxWidth(),mode)
        } else {
            Row(
                Modifier.fillMaxSize()
            ) {
                AboutMe(Modifier.fillMaxWidth(0.3f), mode)
                AboutProject(Modifier.fillMaxWidth(0.7f),mode)
            }
        }
    }
}



internal expect fun openUrl(url: String?)