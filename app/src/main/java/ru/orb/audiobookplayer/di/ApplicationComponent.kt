package ru.orb.audiobookplayer.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.orb.audiobookplayer.data.api.Repository
import ru.orb.audiobookplayer.data.impl.RepositoryImpl
import ru.orb.audiobookplayer.domain.GetAudioBooksUseCase
import ru.orb.audiobookplayer.domain.GetAudioBooksUseImpl
import ru.orb.audiobookplayer.presentation.api.MainActivityViewModel
import ru.orb.audiobookplayer.presentation.api.Router
import ru.orb.audiobookplayer.presentation.impl.RouterImpl
import ru.orb.audiobookplayer.presentation.impl.main.MainActivity
import ru.orb.audiobookplayer.presentation.impl.main.MainActivityViewModelImpl
import javax.inject.Scope

@Component(modules = [ApplicationComponent.BindingsModule::class])
interface ApplicationComponent {

    fun repository(): Repository

    fun router(): Router

    fun inject(app: Application)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            context: Context
        ): ApplicationComponent
    }

    @Module
    interface BindingsModule {

        @Binds
        fun bindRepository(repositoryImpl: RepositoryImpl): Repository

        @Binds
        fun bindRouter(routerImpl: RouterImpl): Router
    }
}