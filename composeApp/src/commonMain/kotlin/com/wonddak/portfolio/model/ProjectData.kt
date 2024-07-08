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
import portfolio.composeapp.generated.resources.appstore
import portfolio.composeapp.generated.resources.googleplay
import portfolio.composeapp.generated.resources.link

data class ProjectData(
    var id: Int,
    var type: ProjectType,
    var title: String = "",
    var links: List<LinkData> = emptyList(),
    var icon : DrawableResource? = null,
    var images : List<DrawableResource> = emptyList(),
    var contentDescription :String = ""
) {
    @Composable
    fun makeContentView() {
        Column {
            Text(id.toString())
            Text(title)
            Text(type.name)
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

data class LinkData(
    val type: LinkType,
    val url: String,
) {
    enum class LinkType(drawableResource: DrawableResource) {
        PlayStore(Res.drawable.googleplay),
        AppStore(Res.drawable.appstore),
        Other(Res.drawable.link)
    }
}

