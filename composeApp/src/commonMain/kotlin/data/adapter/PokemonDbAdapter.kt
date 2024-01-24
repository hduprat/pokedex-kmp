package data.adapter

import data.model.Pokemon

class PokemonDbAdapter {
    companion object {
        fun toModel(dbObj: dev.duprat.pokedex.sqldelight.data.Pokemon): Pokemon = Pokemon(
            id = dbObj.id.toInt(),
            name = dbObj.name,
            enName = dbObj.enName,
            sprite = dbObj.sprite,
            genus = dbObj.genus,
            description = dbObj.description,
        )

        fun toDbObject(model: Pokemon): dev.duprat.pokedex.sqldelight.data.Pokemon =
            dev.duprat.pokedex.sqldelight.data.Pokemon(
                id = model.id.toLong(),
                name = model.name,
                enName = model.enName,
                sprite = model.sprite,
                genus = model.genus,
                description = model.description
            )
    }
}