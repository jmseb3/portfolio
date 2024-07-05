package com.wonddak.portfolio.model

import org.jetbrains.compose.resources.DrawableResource
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
)

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

