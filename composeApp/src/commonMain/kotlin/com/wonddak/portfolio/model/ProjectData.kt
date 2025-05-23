package com.wonddak.portfolio.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.wonddak.portfolio.theme.getFont
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.appstore
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.googleplay
import portfolio.composeapp.generated.resources.link
import portfolio.composeapp.generated.resources.velog

data class ProjectData(
    var id: Int,
    var type: ProjectType,
    var title: String = "",
    var links: List<LinkData> = emptyList(),
    var icon: DrawableResource? = null,
    var images: List<Any> = emptyList(),
    var contentDescription: String = "",
) {
    @Composable
    fun makeContentView() {
        val uriHandler = LocalUriHandler.current
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                icon?.let { iconData ->
                    Image(
                        painterResource(iconData),
                        null,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(15.dp))
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "$title [${type.name}]"
                    )
                    HorizontalDivider()
                    Text("Link")
                    LazyRow {
                        items(links) { item ->
                            IconButton(
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                                onClick = { uriHandler.openUri(item.url) },
                            ) {
                                Icon(
                                    painter = painterResource(item.type.drawableResource),
                                    contentDescription = null,
                                    tint = item.type.color,
                                    modifier = Modifier
                                )
                            }
                        }
                    }
                }
            }
            HorizontalDivider()
            SelectionContainer {
                Text(contentDescription)
            }
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(images) { item ->
                    val modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                        .then(
                            if (type == ProjectType.App) {
                                Modifier
                                    .width(200.dp)
                                    .aspectRatio(9 / 16f)
                            } else {
                                Modifier
                            }
                        )

                    if (item is DrawableResource) {
                        Image(
                            painter = painterResource(item),
                            contentDescription = null,
                            modifier = modifier
                        )
                    } else {
                        val painter = rememberAsyncImagePainter(item)
                        val state by painter.state.collectAsState()

                        when (state) {
                            is AsyncImagePainter.State.Empty,
                            is AsyncImagePainter.State.Loading -> {
                                CircularProgressIndicator()
                            }
                            is AsyncImagePainter.State.Success -> {
                                Image(
                                    painter = painter,
                                    contentDescription = null
                                )
                            }
                            is AsyncImagePainter.State.Error -> {
                                SelectionContainer {
                                    Text(state.toString())
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun makePreview(
        onClick: () -> Unit,
    ) {
        Column(
            modifier = Modifier
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                .clickable {
                    onClick()
                }
        ) {
            if (icon == null) {
                Column(
                    modifier = Modifier.padding(10.dp)
                        .aspectRatio(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        fontFamily = getFont(),
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    icon?.let {
                        Image(
                            painter = painterResource(it),
                            contentDescription = null,
                            modifier = Modifier.aspectRatio(1f)
                        )
                    }
                    Text(
                        text = title,
                        fontFamily = getFont()
                    )
                }
            }
        }
    }
}

enum class ProjectType {
    App,
    Library,
    Plugin,
    Convention
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

    data class GitHubRepo(val repoPath: String) :
        LinkData(LinkType.GitHub, "https://github.com/jmseb3/$repoPath")

    data class Velog(val userId: String) :
        LinkData(LinkType.Velog, "https://velog.io/@$userId/posts")

    data class Other(override val url: String) : LinkData(LinkType.Other, url)
}

