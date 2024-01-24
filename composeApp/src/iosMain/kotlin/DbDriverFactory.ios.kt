@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import dev.duprat.pokedex.Database

actual class DbDriverFactory {
    actual fun createDriver(): SqlDriver = NativeSqliteDriver(Database.Schema, "database.db")
}