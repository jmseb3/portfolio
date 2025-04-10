package com.wonddak.portfolio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.wonddak.portfolio.data.projectList
import com.wonddak.portfolio.model.ProjectData
import com.wonddak.portfolio.theme.AppTheme
import com.wonddak.portfolio.theme.getFont
import com.wonddak.portfolio.ui.HomeView
import com.wonddak.portfolio.ui.ProjectView
import com.wonddak.portfolio.ui.StartView

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun App(
    navController: NavHostController = rememberNavController()
) = AppTheme {
    val selectModel = SelectModel()
    var mode by remember {
        mutableStateOf(Mode.Desktop)
    }
    val configuration = LocalWindowInfo.current.containerSize

    LaunchedEffect(configuration) {
        mode = if (configuration.width >= 1200) {
            Mode.Desktop
        } else {
            Mode.Mobile
        }
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    LaunchedEffect(navBackStackEntry) {
        println(navBackStackEntry)
    }

    NavHost(
        navController = navController,
        startDestination = Screen.HOME.name,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        composable(Screen.START.name) {
            StartView(
                navigationToHome = {
                    navController.navigate(Screen.HOME.name)
                }
            )
        }
        composable(Screen.HOME.name) {
            HomeView(
                mode,
                selectModel,
                navigateProject = { item ->
                    navController.navigate("${Screen.PROJECT.name}/${item.id}")
                }
            )
        }
        composable(
            route = "${Screen.PROJECT.name}/{$PROJECT_ID}",
            arguments = listOf(navArgument(PROJECT_ID) {
                type = NavType.IntType
                defaultValue = 0
            })
        ) { backStackEntry ->
            val projectId: Int = backStackEntry.arguments?.getInt(PROJECT_ID) ?: 0
            ProjectView(
                data = projectList.find { it.id == projectId },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

internal const val PROJECT_ID = "projectId"

enum class Screen() {
    START,
    HOME,
    PROJECT
}
