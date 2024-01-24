package data

import data.dto.PokemonDto
import data.dto.PokemonPageDto
import data.dto.PokemonSpeciesDto
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int,
    ): PokemonPageDto

    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): PokemonDto

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecies(@Path("name") name: String): PokemonSpeciesDto
}