package data

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
}

val ktorfit = Ktorfit.Builder().httpClient(httpClient).baseUrl("https://pokeapi.co/api/v2/").build()

val api = ktorfit.create<ApiService>()

