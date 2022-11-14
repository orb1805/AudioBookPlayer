package ru.orb.audiobookplayer.presentation.impl

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ru.orb.audiobookplayer.R
import ru.orb.audiobookplayer.domain.Book

@Composable
fun BookCover(book: Book) {
    Column {
        Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "")
        Text(text = book.title)
    }
}

@Preview
@Composable
fun Preview() {
    BookCover(Book("Книга"))
}