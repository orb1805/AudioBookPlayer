package ru.orb.audiobookplayer.presentation.impl.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.orb.audiobookplayer.data.api.Repository
import ru.orb.audiobookplayer.data.impl.RepositoryImpl
import ru.orb.audiobookplayer.domain.Book
import ru.orb.audiobookplayer.domain.GetAudioBooksUseCase
import ru.orb.audiobookplayer.domain.GetAudioBooksUseImpl
import ru.orb.audiobookplayer.presentation.api.MainActivityViewModel
import javax.inject.Inject

class MainActivityViewModelImpl @Inject constructor(
    private val getAudioBooksUseCase: GetAudioBooksUseCase
) : MainActivityViewModel, ViewModel() {

    override val books = MutableLiveData<List<Book>>()

    override fun start() {
        books.value = getAudioBooksUseCase.execute()
    }
}