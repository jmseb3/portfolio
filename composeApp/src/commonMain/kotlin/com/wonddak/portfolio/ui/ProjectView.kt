package com.wonddak.portfolio.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wonddak.portfolio.model.ProjectData

@Composable
fun ProjectView(
    data: ProjectData?,
    onBack: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.padding(20.dp)
        ) {
            Icon(Icons.Filled.Close, null)
        }
        if (data == null) {
            Text("잘못된 곳으로 오신것 같군요")
        } else {
            data.makeContentView()
        }
    }
}