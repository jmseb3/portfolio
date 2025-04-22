package com.wonddak.portfolio.model

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Start : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data class Project(val id: Int) : Screen
}