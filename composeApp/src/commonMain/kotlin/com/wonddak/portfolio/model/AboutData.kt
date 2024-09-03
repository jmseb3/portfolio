package com.wonddak.portfolio.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


data class IconData(
    val res: DrawableResource,
    val openUrl: String,
    val tintColor: Color? = null,
) {
    constructor(
        data: LinkData,
    ) : this(data.type.drawableResource, data.url, data.type.color)

    constructor(
        type: LinkType,
        url: String,
        tintColor: Color? = null,
    ) : this(type.drawableResource, url, tintColor ?: type.color)

    @Composable
    fun makeView(modifier: Modifier) {
        val uriHandler = LocalUriHandler.current
        IconButton(
            modifier = modifier.padding(horizontal = 4.dp, vertical = 4.dp),
            onClick = { uriHandler.openUri(openUrl) },
        ) {
            Icon(
                painter = painterResource(res),
                contentDescription = null,
                tint = tintColor ?: LocalContentColor.current,
                modifier = Modifier
            )
        }
    }
}

data class ProfileData(
    val res: DrawableResource,
) {

    @Composable
    fun makeView(modifier: Modifier) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(res),
                contentDescription = "wonhee's profile",
                modifier = Modifier.clip(CircleShape).size(100.dp)
            )
            Text(
                "안녕하세요\n성장하는 개발자 원딱 입니다.",
                modifier = Modifier,
                textAlign = TextAlign.Center
            )
        }
    }

}