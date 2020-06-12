package com.sama.useradmin.di.component

import com.sama.useradmin.MyApplication
import com.sama.useradmin.di.module.ActivityBuilder
import com.sama.useradmin.di.module.DbModule
import com.sama.useradmin.di.module.RepositoryModule
import com.sama.useradmin.di.module.view_model.ViewModelFactoryBinding
import com.sama.useradmin.di.module.view_model.ViewModelsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        ViewModelsModule::class,
        ViewModelFactoryBinding::class,
        DbModule::class,
        RepositoryModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(myApplication: MyApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: MyApplication)
}