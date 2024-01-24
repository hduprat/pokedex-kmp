package di

import DbDriverFactory
import data.db.PokemonDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val databaseModule = module {
    single { DbDriverFactory(androidContext()).createDriver() }
    singleOf(::PokemonDatabase)
}