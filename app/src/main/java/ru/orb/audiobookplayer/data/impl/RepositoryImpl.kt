package ru.orb.audiobookplayer.data.impl

import android.os.Environment
import ru.orb.audiobookplayer.data.api.Repository
import java.io.File
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {

    override fun getAudioBooksList(): List<File> =
        getAudioBooksFolder().listFiles()?.asList() ?: throw Exception("Audiobooks folder is empty")

    override fun getAudioBookFiles(bookName: String): List<File> =
        getAudioBooksFolder()
            .listFiles()
            ?.find { it.name == bookName }
            ?.listFiles()
            ?.asList()
            ?: throw Exception("No such book")

    private fun getAudioBooksFolder(): File {
        if (isStorageAvailable()) throw Exception("No storage access")
        return File(Environment.getExternalStorageDirectory(), AUDIO_BOOKS_DIR_NAME)
    }

    private fun isStorageAvailable(): Boolean {
        val state = Environment.getExternalStorageState()
        return state != Environment.MEDIA_MOUNTED_READ_ONLY && state != Environment.MEDIA_MOUNTED
    }

    private companion object {

        const val AUDIO_BOOKS_DIR_NAME = "Audiobooks"
    }
}