package com.wonddak.portfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        document.title = "WonDDak Portfolio"
        val body = document.body!!
        ComposeViewport(body) {
            App()
        }
    }
}
