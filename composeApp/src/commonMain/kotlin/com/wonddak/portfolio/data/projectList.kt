package com.wonddak.portfolio.data

import com.wonddak.portfolio.model.IconData
import com.wonddak.portfolio.model.LinkData
import com.wonddak.portfolio.model.LinkType
import com.wonddak.portfolio.model.ProfileData
import com.wonddak.portfolio.model.ProjectData
import com.wonddak.portfolio.model.ProjectType
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.app_dec_mt_1
import portfolio.composeapp.generated.resources.app_dec_mt_2
import portfolio.composeapp.generated.resources.app_dec_mt_3
import portfolio.composeapp.generated.resources.app_dec_mt_4
import portfolio.composeapp.generated.resources.app_dec_mt_5
import portfolio.composeapp.generated.resources.profile
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
            Res.drawable.app_dec_mt_1,
            Res.drawable.app_dec_mt_2,
            Res.drawable.app_dec_mt_3,
            Res.drawable.app_dec_mt_4,
            Res.drawable.app_dec_mt_5,
        ),
        contentDescription = """
            여행 갈때 인원,돈,계획 관리를 한번에 관리 할 수 있는 기능을 제공하는 앱입니다..
            Compose MultiPlatform을 이용하여 Android/IOS에서 사용 가능 하도록 되어 있습니다.
        """.trimIndent()
    ),
    ProjectData(
        id = 3,
        type = ProjectType.App,
        title = "LoaCell",
        links = listOf(
            LinkData.PlayStore("com.wonddak.loacell"),
            LinkData.AppStore("")
        )
    ),
    ProjectData(
        4,
        ProjectType.Library,
        "SImp jwt parser"
    ),
    ProjectData(
        5,
        ProjectType.Library,
        "HelLogin"
    ),
    ProjectData(
        6,
        ProjectType.Library,
        "Compose Switch"
    ),
    ProjectData(
        7,
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