package com.wonddak.portfolio.data

import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import com.wonddak.portfolio.model.IconData
import com.wonddak.portfolio.model.LinkData
import com.wonddak.portfolio.model.LinkType
import com.wonddak.portfolio.model.ProfileData
import com.wonddak.portfolio.model.ProjectData
import com.wonddak.portfolio.model.ProjectType
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.appstore
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.googleplay
import portfolio.composeapp.generated.resources.profile
import portfolio.composeapp.generated.resources.velog
import portfolio.composeapp.generated.resources.icon_app_mt

val projectList = setOf(
    ProjectData(
        id = 1,
        type = ProjectType.App,
        title = "시원한 수학박사",
        links = listOf(
            LinkData.PlayStore("com.math.watermelon")
        )
    ),
    ProjectData(
        id = 2,
        type = ProjectType.App,
        title = "MT 매니저",
        links = listOf(
            LinkData.PlayStore("com.wonddak.mtmanger"),
            LinkData.AppStore("6526487049")
        ),
        icon = Res.drawable.icon_app_mt,
        images = listOf(

        ),
        contentDescription = """
            MT 관리를 위한 앱입니다.
        """.trimIndent()
    ),
    ProjectData(
        id = 3,
        type = ProjectType.App,
        title = "LoaCell",
        links = listOf(
            LinkData.PlayStore("com.wonddak.mtmanger"),
            LinkData.AppStore("6526487049")
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
        LinkData.GitHub("jmseb3")
    ),
    IconData(
        LinkData.Velog("jmseb3")
    ),
    IconData(
        LinkType.PlayStore,
        "https://play.google.com/store/apps/developer?id=WonDDak",
    ),
    IconData(
        LinkType.AppStore,
        "https://apps.apple.com/kr/developer/jung-wonhee/id1723807756",
    )
)