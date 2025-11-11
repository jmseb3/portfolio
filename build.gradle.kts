plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.serialization).apply(false)
    id("com.github.ben-manes.versions") version "0.51.0"
}
