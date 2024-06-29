package com.wonddak.portfolio.model

import org.jetbrains.compose.resources.DrawableResource

data class ProjectData(
    var id : Int,
    var type : ProjectType,
    var title :String = "",
    var icon : DrawableResource? = null,
    var images : List<DrawableResource> = emptyList(),
    var contentDescription :String = ""
)

enum class ProjectType {
    App,
    Library,
    Plugin
}