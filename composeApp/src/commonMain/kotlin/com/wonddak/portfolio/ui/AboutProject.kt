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
import com.wonddak.portfolio.model.ProjectData
import com.wonddak.portfolio.model.ProjectType

@Composable
fun AboutProject(
    mode: Mode,
    selectModel: SelectModel,
    modifier: Modifier,
    navigateProject: (id: Int) -> Unit,
) {
    val nowType = selectModel.nowType
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
            items(projectList.filter { it.type == nowType }) { item ->
                item.makePreview {
                    navigateProject(item.id)
                }
            }
        }
    }
}

val projectList = setOf(
    ProjectData(
        1,
        ProjectType.App,
        "시원한 수학박사"
    ),
    ProjectData(
        2,
        ProjectType.Library,
        "SImp jwt parser"
    ),
    ProjectData(
        3,
        ProjectType.Plugin,
        "Font Helper"
    )
)