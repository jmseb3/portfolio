package com.wonddak.portfolio.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.wonddak.portfolio.model.ProjectData

@Composable
fun ProjectView(data: ProjectData?) {
    if (data == null) {
        Text("잘못된 곳으로 오신것 같군요")
    } else {
        data.makeContentView()
    }
}