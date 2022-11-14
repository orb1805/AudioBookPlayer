package ru.orb.audiobookplayer.presentation.api

import androidx.lifecycle.LiveData
import ru.orb.audiobookplayer.domain.Book

interface MainActivityViewModel {

    val books: LiveData<List<Book>>

    fun start()
}