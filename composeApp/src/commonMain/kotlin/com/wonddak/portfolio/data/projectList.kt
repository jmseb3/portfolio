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
import portfolio.composeapp.generated.resources.icon_app_coin
import portfolio.composeapp.generated.resources.icon_app_loacell
import portfolio.composeapp.generated.resources.icon_app_math
import portfolio.composeapp.generated.resources.icon_app_mt
import portfolio.composeapp.generated.resources.profile

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
            Fragment를 활용한 여러 화면 이동 통해  개념정리와 문제풀이를 할 수 있습니다.
            제일 처음 대학생때 과제로 제출하였던 앱입니다.
            
            Room Firebase
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
            2차 마이그레이션으로 Compose MultiPlatform을 이용하여 Android/Ios에서 사용 가능 하도록 되어 있습니다.
            
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
            Kotlin Multiplaform을 이용하여 로직 공유에 초점을 맞추었습니다.
            firebase의 storage/store/auth 기능들을 주로 사용 하였습니다.
            이후 Compose Multiplaform으로 개선하여 두앱 모두 동일한 UI를 가지도록 되어있습니다.
            
            Room Firebase Koin Ktor ViewModel Navigation
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
            1차 마이그레이션으로 XML > Compose으로 변환 하였습니다.
            
            최초 제작시에는 retorift을 통한 upBit의 코인 시세를 받아오는 기능이 있었습니다
            하지만 마이그레이션 하면서 불필요하다 생각하여 제거되었습니다.
        """.trimIndent()
    ),
    ProjectData(
        id = 5,
        type = ProjectType.Library,
        title = "Simple jwt parser",
        links = listOf(
            LinkData.GitHubRepo("KMM-Simple-JWT-Parser")
        ),
        contentDescription = """
            JWT Token의 payload부분을 JsonObject로 반환해주는 간단한 라이브러리입니다.
        """.trimIndent()
    ),
    ProjectData(
        id = 6,
        type = ProjectType.Library,
        title = "HelLogin",
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
        id = 7,
        type = ProjectType.Library,
        title = "Compose Switch",
        links = listOf(
            LinkData.GitHubRepo("SwitchView-Compose")
        ),
        images = listOf(
//            "https://raw.githubusercontent.com/jmseb3/SwitchView-Compose/refs/heads/main/screenshots/sectionSwitchView.gif",
        ),
        contentDescription = """
            기본으로 제공되는 스위치기능을 보다 커스텀 할 수 있도록 제공하는 라이브러리 입니다.
        """.trimIndent()
    ),
    ProjectData(
        id = 8,
        type = ProjectType.Plugin,
        title = "Font Helper",
        links = listOf(
            LinkData.GitHubRepo("Android_Font_Helper_Plugin")
        ),
        images = listOf(
//            "https://raw.githubusercontent.com/jmseb3/Android_Font_Helper_Plugin/refs/heads/main/screenshot/01.open_tool.png",
//            "https://raw.githubusercontent.com/jmseb3/Android_Font_Helper_Plugin/refs/heads/main/screenshot/02.setting.png"
        ),
        contentDescription = """
            간편하게 Font파일 제작을 도와주는 플러그인 입니다.
        """.trimIndent()
    ),
    ProjectData(
        id = 9,
        type = ProjectType.Library,
        title = "Capturable",
        links = listOf(
            LinkData.GitHubRepo("Capturable")
        ),
        contentDescription = """
            Compose Multiplatform에서 @Composable한 View를 이미지(ImageBitmap)로 변환해주는 라이브러리입니다
            기존에 Android 용으로 제작되었던 라이브러리를 Fork 및 수정하여 CMP용으로 제공하고있습니다.
        """.trimIndent()
    ),
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