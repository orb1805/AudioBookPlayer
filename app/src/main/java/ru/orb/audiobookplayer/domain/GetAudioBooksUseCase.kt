package ru.orb.audiobookplayer.domain

import ru.orb.audiobookplayer.data.api.Repository
import javax.inject.Inject

interface GetAudioBooksUseCase {

    fun execute(): List<Book>
}

class GetAudioBooksUseImpl  @Inject constructor(private val repository: Repository) : GetAudioBooksUseCase {

    override fun execute(): List<Book> {
        val directory = repository.getAudioBooksList()
        return directory.map { Book(title = it.name) }
    }
}