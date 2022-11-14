package ru.orb.audiobookplayer.data.api

import java.io.File

interface Repository {

    fun getAudioBooksList(): List<File>

    fun getAudioBookFiles(bookName: String): List<File>
}