package com.sama.useradmin.di.module

import androidx.room.Room
import com.sama.useradmin.MyApplication
import com.sama.useradmin.data.repository.local.Db
import com.sama.useradmin.data.repository.local.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule{
    @Singleton
    @Provides
    fun provideDb(app: MyApplication): Db {
        return Room
            .databaseBuilder(app, Db::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideVenueDao(db: Db): UserDao {
        return db.userDao()
    }
}