package com.wonddak.portfolio

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import com.wonddak.portfolio.data.projectList
import com.wonddak.portfolio.model.Screen
import com.wonddak.portfolio.theme.AppTheme
import com.wonddak.portfolio.ui.HomeView
import com.wonddak.portfolio.ui.ProjectView

@Composable
internal fun App(
    navController: NavHostController
) = AppTheme {

    setSingletonImageLoaderFactory {
        ImageLoader.Builder(PlatformContext.INSTANCE)
            .crossfade(true)
            .build()
    }

    val selectModel = remember {
        SelectModel()
    }
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

    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        composable<Screen.Home> {
            HomeView(
                mode,
                selectModel,
                navigateProject = { item ->
                    navController.navigate(Screen.Project(item.id)) {

                    }
                }
            )
        }
        composable<Screen.Project> { backStackEntry ->
            val projectRoute = backStackEntry.toRoute<Screen.Project>()
            ProjectView(
                data = projectList.find { it.id == projectRoute.id },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
