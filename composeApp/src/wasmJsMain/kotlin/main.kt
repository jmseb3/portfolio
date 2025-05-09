import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToNavigation
import androidx.navigation.compose.rememberNavController
import com.wonddak.portfolio.App
import com.wonddak.portfolio.model.Screen
import kotlinx.browser.window
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.configureWebResources
import org.jetbrains.compose.resources.preloadFont
import portfolio.composeapp.generated.resources.MangoDdobak_R
import portfolio.composeapp.generated.resources.Res

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
@ExperimentalBrowserHistoryApi
fun main() {
    configureWebResources {
        // Overrides the resource location
        resourcePathMapping { path -> "./$path" }
    }
    CanvasBasedWindow("WonDDak Portfolio", canvasElementId = "canvas") {
        val mangoFont by preloadFont(Res.font.MangoDdobak_R)

        val navController = rememberNavController()

        App(
            navController = navController
        )
        LaunchedEffect(Unit) {
            window.bindToNavigation(navController)
        }

        if (mangoFont != null) {
            println("Fonts are ready")
        } else {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Color.White.copy(alpha = 0.8f))
                    .clickable { }) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            println("Fonts are not ready yet")
        }
    }
}
