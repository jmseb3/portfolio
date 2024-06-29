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
import com.wonddak.portfolio.SelectModel

@Composable
fun HomeView(
    mode: Mode,
    selectModel: SelectModel,
    navigateProject: (id: Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (mode == Mode.Mobile) {
            AboutMe(mode, Modifier.fillMaxWidth())
            AboutProject(mode, selectModel, Modifier.fillMaxWidth(), navigateProject)
        } else {
            Row(
                Modifier.fillMaxSize()
            ) {
                AboutMe(mode, Modifier.fillMaxWidth(0.3f).fillMaxHeight())
                AboutProject(
                    mode,
                    selectModel,
                    Modifier.fillMaxWidth(0.7f).fillMaxHeight(),
                    navigateProject
                )
            }
        }
    }
}