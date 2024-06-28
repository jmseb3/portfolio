package com.wonddak.portfolio.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wonddak.portfolio.Mode

@Composable
fun HomeView(
    mode: Mode,
    navigateProject: (id:Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (mode == Mode.Mobile) {
            AboutMe(Modifier.fillMaxWidth(), mode)
            AboutProject(Modifier.fillMaxWidth(), mode)
        } else {
            Row(
                Modifier.fillMaxSize()
            ) {
                AboutMe(Modifier.fillMaxWidth(0.3f).fillMaxHeight(), mode)
                AboutProject(Modifier.fillMaxWidth(0.7f).fillMaxHeight(), mode)
            }
        }
    }
}