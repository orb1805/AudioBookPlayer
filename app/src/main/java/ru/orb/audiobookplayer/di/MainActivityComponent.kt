package ru.orb.audiobookplayer.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.orb.audiobookplayer.domain.GetAudioBooksUseCase
import ru.orb.audiobookplayer.domain.GetAudioBooksUseImpl
import ru.orb.audiobookplayer.presentation.impl.main.MainActivityViewModelImpl
import ru.orb.audiobookplayer.presentation.api.MainActivityViewModel
import ru.orb.audiobookplayer.presentation.impl.main.MainActivity

@Component(modules = [MainActivityComponent.BindingsModule::class])
interface MainActivityComponent {

    fun getAudioBooksUseCase(): GetAudioBooksUseCase

    fun getViewModel(): MainActivityViewModel

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    @Module
    interface BindingsModule {

        @Binds
        fun bindGetAudioBooksUseCase(getAudioBooksUseImpl: GetAudioBooksUseImpl): GetAudioBooksUseCase

        @Binds
        fun bindViewModel(mainActivityViewModelImpl: MainActivityViewModelImpl): MainActivityViewModel
    }
}