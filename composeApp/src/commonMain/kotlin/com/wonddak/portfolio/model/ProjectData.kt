package com.wonddak.portfolio.model

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.MangoDdobak_R
import portfolio.composeapp.generated.resources.Res

data class ProjectData(
    var id : Int,
    var type : ProjectType? = null,
    var title :String = "",
    var icon : DrawableResource? = null,
    var images : List<DrawableResource> = emptyList(),
    var contentDescription :String = ""
) {
    @Composable
    fun makeContentView() {
        Column {
            Text(id.toString())
            Text(title)
            Text(type?.name ?: "null")
        }
    }

    @Composable
    fun makePreview(
        onClick : () -> Unit
    ) {
        TextButton(
            onClick = onClick,
        ) {
            Text(
                title,
                fontFamily = FontFamily(
                    Font(Res.font.MangoDdobak_R)
                )
            )
        }
    }
}

enum class ProjectType {
    App,
    Library,
    Plugin
}