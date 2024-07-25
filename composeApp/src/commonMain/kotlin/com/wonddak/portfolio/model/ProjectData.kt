package com.wonddak.portfolio.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import portfolio.composeapp.generated.resources.velog
import portfolio.composeapp.generated.resources.github

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
            Row {
                icon?.let { iconData ->
                    Image(painterResource(iconData), null, modifier = Modifier.size(200.dp))
                }
                Column {
                    Text(title)
                    Text(type.name)
                }
            }
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

enum class LinkType(val drawableResource: DrawableResource, val color: Color) {
    PlayStore(Res.drawable.googleplay, Color(0xff78C257)),
    AppStore(Res.drawable.appstore, Color(0xff0D96F6)),
    Velog(Res.drawable.velog, Color(0xff20C997)),
    GitHub(Res.drawable.github, Color(0xff181717)),
    Other(Res.drawable.link, Color(0xffffff))
}

sealed class LinkData(
    val type: LinkType,
    open val url: String,
) {
    data class PlayStore(val packageName: String) :
        LinkData(LinkType.PlayStore, "https://play.google.com/store/apps/details?id=$packageName")

    data class AppStore(val appId: String) :
        LinkData(LinkType.AppStore, "https://apps.apple.com/app/id$appId")

    data class GitHub(val userId: String) :
        LinkData(LinkType.GitHub, "https://github.com/$userId")

    data class Velog(val userId: String) :
        LinkData(LinkType.Velog, "https://velog.io/@$userId/posts")

    data class Other(override val url: String) : LinkData(LinkType.Other, url)
}

