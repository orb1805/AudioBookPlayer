package ru.orb.audiobookplayer.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.orb.audiobookplayer.presentation.api.PlayerViewModel
import ru.orb.audiobookplayer.presentation.impl.player.PlayerActivity
import ru.orb.audiobookplayer.presentation.impl.player.PlayerViewModelImpl

@Component(modules = [PlayerActivityComponent.BindingsModule::class])
interface PlayerActivityComponent {

    fun getViewModel(): PlayerViewModel

    fun inject(activity: PlayerActivity)

    @Component.Factory
    interface Factory {
        fun create(): PlayerActivityComponent
    }

    @Module
    interface BindingsModule {

        @Binds
        fun bindViewModel(playerViewModelImpl: PlayerViewModelImpl): PlayerViewModel
    }
}