package com.sama.useradmin.di.module

import com.sama.useradmin.data.repository.Repository
import com.sama.useradmin.data.repository.RepositoryImp
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesRepository(repository: RepositoryImp): Repository
}