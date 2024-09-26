package com.wonddak.portfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    window.onload = {
        document.title = "WonDDak Portfolio"
        onWasmReady {
            val body = document.body ?: return@onWasmReady
            ComposeViewport(body) {
                App()
            }
        }
    }
}