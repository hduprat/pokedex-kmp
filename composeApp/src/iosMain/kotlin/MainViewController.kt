import androidx.compose.ui.window.ComposeUIViewController
import di.databaseModule
import di.pokemonList.pokemonListModule
import org.koin.compose.KoinApplication
import platform.UIKit.UIViewController

@Suppress("unused", "FunctionName")
fun MainViewController(): UIViewController {
    return ComposeUIViewController {
        KoinApplication(application = {
            modules(databaseModule, pokemonListModule)
        }) { App() }
    }
}
