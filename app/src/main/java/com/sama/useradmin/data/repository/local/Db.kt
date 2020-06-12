package com.sama.useradmin.data.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sama.useradmin.data.model.User

@Database(
    entities = [
        User::class
    ],
    version = 1,
    exportSchema = false
)
abstract class Db: RoomDatabase() {

    abstract fun userDao(): UserDao
}