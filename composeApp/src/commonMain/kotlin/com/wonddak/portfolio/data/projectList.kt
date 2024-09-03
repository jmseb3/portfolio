package com.wonddak.portfolio.data

import com.wonddak.portfolio.model.IconData
import com.wonddak.portfolio.model.LinkData
import com.wonddak.portfolio.model.LinkType
import com.wonddak.portfolio.model.ProfileData
import com.wonddak.portfolio.model.ProjectData
import com.wonddak.portfolio.model.ProjectType
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.app_dec_coin_1
import portfolio.composeapp.generated.resources.app_dec_coin_2
import portfolio.composeapp.generated.resources.app_dec_coin_3
import portfolio.composeapp.generated.resources.app_dec_coin_4
import portfolio.composeapp.generated.resources.app_dec_coin_5
import portfolio.composeapp.generated.resources.app_dec_coin_6
import portfolio.composeapp.generated.resources.app_dec_loacell_1
import portfolio.composeapp.generated.resources.app_dec_loacell_2
import portfolio.composeapp.generated.resources.app_dec_loacell_3
import portfolio.composeapp.generated.resources.app_dec_loacell_4
import portfolio.composeapp.generated.resources.app_dec_math_1
import portfolio.composeapp.generated.resources.app_dec_math_2
import portfolio.composeapp.generated.resources.app_dec_math_3
import portfolio.composeapp.generated.resources.app_dec_math_4
import portfolio.composeapp.generated.resources.app_dec_math_5
import portfolio.composeapp.generated.resources.app_dec_mt_1
import portfolio.composeapp.generated.resources.app_dec_mt_2
import portfolio.composeapp.generated.resources.app_dec_mt_3
import portfolio.composeapp.generated.resources.app_dec_mt_4
import portfolio.composeapp.generated.resources.app_dec_mt_5
import portfolio.composeapp.generated.resources.icon_app_loacell
import portfolio.composeapp.generated.resources.icon_app_math
import portfolio.composeapp.generated.resources.icon_app_coin
import portfolio.composeapp.generated.resources.profile
import portfolio.composeapp.generated.resources.icon_app_mt

val projectList = setOf(
    ProjectData(
        id = 1,
        type = ProjectType.App,
        title = "시원한 수학박사",
        links = listOf(
            LinkData.PlayStore("com.math.watermelon")
        ),
        icon = Res.drawable.icon_app_math,
        images = listOf(
            Res.drawable.app_dec_math_1,
            Res.drawable.app_dec_math_2,
            Res.drawable.app_dec_math_3,
            Res.drawable.app_dec_math_4,
            Res.drawable.app_dec_math_5,
        ),
        contentDescription = """
            수학 개념 정리를 위한 앱 입니다.
            간단한 개념정리와 문제풀이를 할 수 있습니다.
            제일 처음 대학생때 과제로 제출하였던 앱입니다.
            
            Room firebase
        """.trimIndent()
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
            여행 갈때 인원,돈,계획 관리를 한번에 관리 할 수 있는 기능을 제공하는 앱입니다.
            처음에는 안드로이드만 제공 하였고,
            1차 마이그레이션으로 XML > Compose로 변경 하였고,
            2차 마이그레이션으로 Compose MultiPlatform을 이용하여 Android/IOS에서 사용 가능 하도록 되어 있습니다.
            
            Room Firebase Koin Ktor ViewModel
        """.trimIndent()
    ),
    ProjectData(
        id = 3,
        type = ProjectType.App,
        title = "LoaCell",
        links = listOf(
            LinkData.PlayStore("com.wonddak.loacell.android"),
            LinkData.AppStore("6475280029")
        ),
        icon = Res.drawable.icon_app_loacell,
        images = listOf(
            Res.drawable.app_dec_loacell_1,
            Res.drawable.app_dec_loacell_2,
            Res.drawable.app_dec_loacell_3,
            Res.drawable.app_dec_loacell_4,
        ),
        contentDescription = """
            제가 즐겨하는 게임인 로스트아크라는 게임에서 친구들과 파티 관리를 위해 제작했습니다..
            Kotlin Multiplaform을 이용하여 로직 공유에 초점을 맞추었고,
            firbase의 storage/store/auth 기능들을 주로 사용 하였습니다.
            
            Room Firebase Koin Ktor ViewModel
        """.trimIndent()
    ),
    ProjectData(
        id = 4,
        type = ProjectType.App,
        title = "코인 평단 계산기",
        links = listOf(
            LinkData.PlayStore("com.wonddak.coinaverage"),
        ),
        icon = Res.drawable.icon_app_coin,
        images = listOf(
            Res.drawable.app_dec_coin_1,
            Res.drawable.app_dec_coin_2,
            Res.drawable.app_dec_coin_3,
            Res.drawable.app_dec_coin_4,
            Res.drawable.app_dec_coin_5,
            Res.drawable.app_dec_coin_6,
        ),
        contentDescription = """
            여러 사이트에서 관리중인 나의 코인/주식을 한번에 계산해주는 간단한 계산기 어플입니다.
            1차 마이그레이션으로 XML > Compose을 지원하게되었습니다.
        """.trimIndent()
    ),
    ProjectData(
        5,
        ProjectType.Library,
        "SImp jwt parser",
        links = listOf(
            LinkData.GitHubRepo("KMM-Simple-JWT-Parser")
        ),
        contentDescription = """
            JWT Token의 payload부분을 JsonObject로 반환해주는 간단한 라이브러리입니다.
        """.trimIndent()
    ),
    ProjectData(
        6,
        ProjectType.Library,
        "HelLogin",
        links = listOf(
            LinkData.GitHubRepo("helLogin")
        ),
        contentDescription = """
            Hello + Login을 합쳐서 HelLogin 입니다.
            Compose MultiPlatform에서 로그인 할 일이 있으신가요?
            여러 소셜 로그인을 제공하는 기능으로 간단하게 구현해보세요.
            필요하면 ui도 지원해 준답니다.
        """.trimIndent()
    ),
    ProjectData(
        7,
        ProjectType.Library,
        "Compose Switch",
        links = listOf(
            LinkData.GitHubRepo("SwitchView-Compose")
        ),
        contentDescription = """
            기본으로 제공되는 스위치기능을 보다 커스텀 할 수 있도록 제공하는 라이브러리 입니다.
        """.trimIndent()
    ),
    ProjectData(
        8,
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