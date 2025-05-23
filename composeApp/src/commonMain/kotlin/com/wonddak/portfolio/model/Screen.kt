package com.wonddak.portfolio.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    @SerialName("home")
    data object Home : Screen

    @Serializable
    @SerialName("project")
    data class Project(val id: Int) : Screen
}