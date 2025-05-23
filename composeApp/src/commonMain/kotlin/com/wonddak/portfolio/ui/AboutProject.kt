package com.wonddak.portfolio.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wonddak.portfolio.Mode
import com.wonddak.portfolio.SelectModel
import com.wonddak.portfolio.data.projectList
import com.wonddak.portfolio.model.ProjectData
import com.wonddak.portfolio.model.ProjectType

/**
 * The List Of My Project View
 */
@Composable
fun AboutProject(
    mode: Mode,
    selectModel: SelectModel,
    modifier: Modifier,
    navigateProject: (ProjectData) -> Unit,
) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            mode.name
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            ProjectType.entries.forEach {
                Button(
                    onClick = {
                        selectModel.updateNowType(it)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(it.name)
                }
            }
        }
        LazyVerticalGrid(
            modifier = Modifier.height(500.dp),
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(
                projectList.filter { it.type == selectModel.nowType },
                key = {
                    it.id
                }
            ) { item ->
                item.makePreview(
                    onClick = {
                        navigateProject(item)
                    }
                )
            }
        }
    }
}