package com.wonddak.portfolio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wonddak.portfolio.theme.AppTheme
import com.wonddak.portfolio.ui.HomeView
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun App(
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

    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    LaunchedEffect(navBackStackEntry) {
        println(navBackStackEntry)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                        enabled = navBackStackEntry?.destination?.route != Screen.HOME.name
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                }
            )

        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.HOME.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(Screen.HOME.name) {
                HomeView(mode, selectModel) { id ->
                    navController.navigate("${Screen.PROJECT.name}/$id")
                }
            }
            composable(
                route = "${Screen.PROJECT.name}/{projectId}",
                arguments = listOf(navArgument("projectId") { type = NavType.IntType })
            ) { backStackEntry ->
                Column {
                    Text("${backStackEntry.arguments?.getInt("projectId")}")
                }
            }
        }
    }

}

internal expect fun openUrl(url: String?)

enum class Screen() {
    HOME,
    PROJECT
}
