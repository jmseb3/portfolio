package com.wonddak.portfolio.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wonddak.portfolio.Mode
import com.wonddak.portfolio.model.IconData
import com.wonddak.portfolio.model.ProfileData
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.appstore
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.googleplay
import portfolio.composeapp.generated.resources.profile
import portfolio.composeapp.generated.resources.velog

@Composable
fun AboutMe(
    mode: Mode,
    modifier: Modifier,
) {
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
    if (mode == Mode.Desktop) {
        Column(
            modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            profile.makeView(Modifier.fillMaxWidth())
            iconData.forEach { icon ->
                icon.makeView(Modifier)
            }
        }
    } else {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            profile.makeView(Modifier.defaultMinSize(minWidth = 150.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
            ) {
                iconData.forEach { icon ->
                    icon.makeView(Modifier.weight(1f))
                }
            }
        }
    }
}