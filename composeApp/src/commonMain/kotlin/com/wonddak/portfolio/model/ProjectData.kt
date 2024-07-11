package com.wonddak.portfolio.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.wonddak.portfolio.openUrl
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
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
    var icon: DrawableResource? = null,
    var images: List<DrawableResource> = emptyList(),
    var contentDescription: String = "",
) {
    @Composable
    fun makeContentView() {
        Column {
            Text(title)
            Text(type.name)
            LazyRow {
                items(links) { item ->
                    IconButton(
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                        onClick = { openUrl(item.url) },
                    ) {
                        Icon(
                            painter = painterResource(item.type.drawableResource),
                            contentDescription = null,
                            tint = LocalContentColor.current,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun makePreview(
        onClick: () -> Unit,
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
    enum class LinkType(val drawableResource: DrawableResource) {
        PlayStore(Res.drawable.googleplay),
        AppStore(Res.drawable.appstore),
        Other(Res.drawable.link)
    }
}

