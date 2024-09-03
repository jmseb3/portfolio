package com.wonddak.portfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    console.log("Welcome to WonDDak Portfolio!!")
    document.addEventListener("DOMContentLoaded", {
        document.body?.let { body ->
            ComposeViewport(body) {
                App()
            }
        }
    })
}