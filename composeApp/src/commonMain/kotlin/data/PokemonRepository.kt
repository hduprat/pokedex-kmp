package data

import app.cash.sqldelight.coroutines.mapToList
import data.adapter.PokemonDbAdapter
import data.adapter.PokemonDtoAdapter
import data.db.PokemonDatabase
import data.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.toList
import org.mobilenativefoundation.store.store5.Fetcher
import org.mobilenativefoundation.store.store5.SourceOfTruth
import org.mobilenativefoundation.store.store5.StoreBuilder
import org.mobilenativefoundation.store.store5.StoreReadRequest
import org.mobilenativefoundation.store.store5.impl.extensions.get

sealed class Key {
    data class Paginated(val start: Int = 0, val size: Int = 10) : Key()
    data object All : Key()
}

fun fetcher(api: ApiService) = Fetcher.of<Key, List<Pokemon>> { key ->
    val offset = if (key is Key.Paginated) key.start else 0
    val limit = if (key is Key.Paginated) key.size else 0

    val result = api.getPokemonList(
        limit = limit, offset = offset
    )

    result.results.asFlow().mapNotNull {
        try {
            val dto = api.getPokemon(it.name)
            val species = api.getPokemonSpecies(it.name)
            PokemonDtoAdapter.toPokemon(dto, species)
        } catch (ex: Exception) {
            null
        }

    }.toList()
}

fun sourceOfTruth(database: PokemonDatabase) = SourceOfTruth.of(reader = { key: Key ->
    when (key) {
        is Key.Paginated -> database.getPaginated(
            key.start, key.size
        ).mapToList(Dispatchers.IO).map { it.map(PokemonDbAdapter::toModel).ifEmpty { null } }

        is Key.All -> database.getAll().mapToList(Dispatchers.IO)
            .map { it.map(PokemonDbAdapter::toModel).ifEmpty { null } }
    }
}, writer = { _, input: List<Pokemon> -> input.map(database::insert) })

class PokemonRepository(api: ApiService, database: PokemonDatabase) {
    private val store = StoreBuilder.from(fetcher(api), sourceOfTruth(database)).build()

    val list = store.stream(StoreReadRequest.cached(Key.All, refresh = false))

    suspend fun loadSubList(start: Int, size: Int) {
        store.get(Key.Paginated(start, size))
    }
}