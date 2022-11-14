package ru.orb.audiobookplayer.presentation.impl.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.createBitmap
import androidx.lifecycle.LiveData
import ru.orb.audiobookplayer.di.DaggerMainActivityComponent
import ru.orb.audiobookplayer.domain.Book
import ru.orb.audiobookplayer.ui.theme.AudioBookPlayerTheme
import javax.inject.Inject
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import ru.orb.audiobookplayer.presentation.api.MainActivityViewModel

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        initDi()
        viewModel.start()

        setContent {
            AudioBookPlayerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainView(booksLivaData = viewModel.books)
                }
            }
        }
    }

    private fun initDi() {
        DaggerMainActivityComponent.factory().create().inject(this)
    }

    @Composable
    fun MainView(booksLivaData: LiveData<List<Book>>) {
        val books by booksLivaData.observeAsState(initial = emptyList())
        AudioBookPlayerTheme {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.Center
            ) {
                items(books) { book ->
                    BookCover(title = book.title)
                }
            }
        }
    }

    @Composable
    fun BookCover(title: String) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                bitmap = createBitmap(100, 300).asImageBitmap(),
                contentDescription = "",
            )
            Text(text = title)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        val books = listOf(Book("Книга 1"), Book("Книга 2"), Book("Книга 3"), Book("Книга 4"))
        MainView(booksLivaData = MutableLiveData(books))
    }
}