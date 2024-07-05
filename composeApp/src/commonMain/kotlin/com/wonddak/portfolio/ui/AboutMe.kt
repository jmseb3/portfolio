package com.wonddak.portfolio.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wonddak.portfolio.Mode
import com.wonddak.portfolio.data.iconData
import com.wonddak.portfolio.data.profile
import com.wonddak.portfolio.model.IconData
import com.wonddak.portfolio.model.ProfileData
import org.jetbrains.compose.ui.tooling.preview.Preview
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.profile
import portfolio.composeapp.generated.resources.velog
import portfolio.composeapp.generated.resources.googleplay
import portfolio.composeapp.generated.resources.appstore

@Composable
fun AboutMe(
    modifier: Modifier,
    mode: Mode,
) {

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
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            profile.makeView(Modifier.defaultMinSize(minWidth = 150.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                iconData.forEach { icon ->
                    icon.makeView(Modifier)
                }
            }
        }
    }
}

@Preview
@Composable
fun AboutMePreview(){
    AboutMe(Modifier, Mode.Desktop)
}