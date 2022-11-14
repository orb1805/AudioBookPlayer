package ru.orb.audiobookplayer

import android.app.Application
import ru.orb.audiobookplayer.di.DaggerApplicationComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent.factory().create(applicationContext).inject(this)
    }
}