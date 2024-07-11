package com.wonddak.portfolio.data

import androidx.compose.ui.graphics.Color
import com.wonddak.portfolio.model.IconData
import com.wonddak.portfolio.model.LinkData
import com.wonddak.portfolio.model.ProfileData
import com.wonddak.portfolio.model.ProjectData
import com.wonddak.portfolio.model.ProjectType
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.appstore
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.googleplay
import portfolio.composeapp.generated.resources.profile
import portfolio.composeapp.generated.resources.velog

val projectList = setOf(
    ProjectData(
        id = 1,
        type = ProjectType.App,
        title = "시원한 수학박사",
        links = listOf(
            LinkData(
                type = LinkData.LinkType.PlayStore,
                "https://play.google.com/store/apps/details?id=com.math.watermelon"
            )
        )
    ),
    ProjectData(
        id = 2,
        type = ProjectType.App,
        title = "MT 매니저",
        links = listOf(
            LinkData(type = LinkData.LinkType.PlayStore, ""),
            LinkData(type = LinkData.LinkType.AppStore, ""),
        )
    ),
    ProjectData(
        id = 3,
        type = ProjectType.App,
        title = "LoaCell",
        links = listOf(
            LinkData(type = LinkData.LinkType.PlayStore, ""),
            LinkData(type = LinkData.LinkType.AppStore, ""),
        )
    ),
    ProjectData(
        4,
        ProjectType.Library,
        "SImp jwt parser"
    ),
    ProjectData(
        5,
        ProjectType.Plugin,
        "Font Helper"
    )
)

val profile = ProfileData(
    Res.drawable.profile
)

val iconData = listOf(
    IconData(
        Res.drawable.github,
        "https://github.com/jmseb3",
        Color(0xff181717)
    ),
    IconData(
        Res.drawable.velog,
        "https://velog.io/@jmseb3/posts",
        Color(0xff20C997)
    ),
    IconData(
        Res.drawable.googleplay,
        "https://play.google.com/store/apps/developer?id=WonDDak",
        Color(0xff78C257)
    ),
    IconData(
        Res.drawable.appstore,
        "https://apps.apple.com/kr/developer/jung-wonhee/id1723807756",
        Color(0xff0D96F6)
    )
)