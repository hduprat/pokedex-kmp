package data.db

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.db.SqlDriver
import data.adapter.PokemonDbAdapter
import data.model.Pokemon
import dev.duprat.pokedex.Database

class PokemonDatabase(driver: SqlDriver) {
    private val db = Database(driver)
    private val queries = db.pokemonQueries

    fun getPaginated(start: Int, size: Int = 10) =
        queries.getPaginated(start = start.toLong(), size = size.toLong()).asFlow()


    fun getAll() = queries.getAll().asFlow()

    fun insert(model: Pokemon) = queries.insert(PokemonDbAdapter.toDbObject(model))
}